package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/13
- @see https://www.acmicpc.net/problem/BOJ_05430
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Deque
- @note
 D의 개수가 배열의 길이보다 많다면 error를 출력
 그게 아니라면 명령을 실행
 */

public class BOJ_05430 {
    static int direction;  // 0이면 왼쪽, 1이면 오른쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String P = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            // main
            direction = 0;
            if (check(P) > deque.size()){
                sb.append("error\n");
            } else {
                for (int i = 0; i < P.length(); i++) {
                    char cmd = P.charAt(i);

                    switch (cmd) {
                        case 'R':
                            reverse();
                            break;
                        case 'D':
                            delete(deque, sb);
                            break;
                    }
                }

                // result
                sb.append("[");
                while (!deque.isEmpty()){
                    if (direction == 0){
                        sb.append(deque.pollFirst());
                    } else{
                        sb.append(deque.pollLast());
                    }

                    if (!deque.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }

    private static void delete(Deque<Integer> deque, StringBuilder sb){
        if (direction == 0){
            deque.pollFirst();
        } else{
            deque.pollLast();
        }
    }

    private static void reverse(){
        if (direction == 0){
            direction++;
        } else{
            direction--;
        }
    }

    private static int check(String P){
        int cnt = 0;
        for (int i = 0; i < P.length(); i++) {
            if (P.charAt(i) == 'D'){
                cnt++;
            }
        }

        return cnt;
    }
}
