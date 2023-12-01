package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 11/29/23
 * - @see https://www.acmicpc.net/problem/1107
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2초 256MB, N <= 500,000
 * - @category # BFS
 * - @note
 * 누를 수 있는 숫자는 눌러서 이동, 만약 고장났다면 +, -를 덜 누를 수 있는 숫자를 누르고 이동(자릿수에 따라 10^k 진행)
 * 97 ~ 103 번은 Math.abs(N - 100) 무조건
 */

public class BOJ_01107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] notWorking = new int[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            // 해당 번호에 1이 저장되어있다면 고장난 버튼
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                notWorking[num] = 1;
            }
        }
        // input 끝

        System.out.println(findTarget(N, Math.abs(100 - N), notWorking));
    }

    private static int digitNum(int num) {
        return String.valueOf(num).length();
    }

    private static int findTarget(int O, int N, int[] notWorking) {
        int target = N;
        for (int i = 0; i <= 1000000; i++) {
            int tmp = i;
            int length = digitNum(i);
            while (length > 0) {
                int num = tmp % 10;
                tmp /= 10;

                if (notWorking[num] == 1) {
                    break;
                }
                length--;

                if (length == 0) {
                    target = Math.min(target, digitNum(i) + Math.abs(O - i));
                }
            }
        }

        return target;
    }

//    private static int findTarget(int N, int[] notWorking) {
//        int target = 0;
//        int pow = 0;
//        while (N != 0) {
//            int num = N % 10;
//            N /= 10;
//
//            Deque<Integer> deque = new ArrayDeque<>();
//            deque.offer(num);
//            while (!deque.isEmpty()) {
//                int tmp = deque.pollFirst();
//                if (notWorking[tmp] == 1) {
//                    deque.offer(tmp - 1);
//                    if (tmp != 9) {
//                        deque.offer(tmp + 1);
//                    }
//                } else{
//                    target += (tmp * (int)Math.pow(10, (pow++)));
//                    break;
//                }
//            }
//        }
//
//        return target;
//    }
}
