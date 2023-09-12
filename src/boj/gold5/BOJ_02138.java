package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-09-11
- @see https://www.acmicpc.net/problem/BOJ_02138
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note
 최단 횟수 내에 구하는 방법
 */

public class BOJ_02138 {
    static class Info{
        int idx, depth;

        public Info(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }

    static int N;
    static char[] original;
    static char[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        original = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        char[] tmp = original.clone();

        // 첫번째 버튼을 누르지 않고 시작
        int answer = 0;
        boolean flag = false;
        for (int i = 1; i < N; i++) {
            flag = false;
            if (check(i)){  // 버튼을 누르지 않았을 때
                flag = true;
                continue;
            }

            if (push(i)){  // 버튼을 눌렀을 때
                flag = true;
                answer++;
                continue;
            }

            if (!flag){
                break;
            }
        }

        // 버튼 누르고 시작
        if (!flag) {
            original = tmp.clone();
            push(0);
            answer = 1;
            for (int i = 1; i < N; i++) {
                flag = false;
                if (check(i)) {  // 버튼을 누르지 않았을 때
                    flag = true;
                    continue;
                }

                if (push(i)) {  // 버튼을 눌렀을 때
                    flag = true;
                    answer++;
                    continue;
                }

                if (!flag) {
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        } else{
            System.out.println(answer);
        }
    }


    private static boolean check(int idx){
        if (idx == N-1){
            if(original[idx-1] == target[idx-1] && original[idx] == target[idx]){
                return true;
            } else{
                return false;
            }
        }

        if (original[idx-1] != target[idx-1]){
            return false;
        } else{
            return true;
        }
    }

    private static boolean push(int idx){
        if (idx == 0){
            change(idx);
            change(idx+1);
        }else if(idx == N-1){
            change(idx);
            change(idx-1);
        } else{
            change(idx);
            change(idx + 1);
            change(idx-1);
        }

        if (idx == 0){
            return true;
        }
        return check(idx);
    }

    private static void change(int idx){
        if (original[idx] == '1'){
            original[idx] = '0';
        } else{
            original[idx] = '1';
        }
    }
}