package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2/3/2024
 * - @see https://www.acmicpc.net/problem/17298
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # DFS
 * - @note
 */

public class BOJ_17298 {
    private static int N;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // input end

        answer = new int[N];
        Arrays.fill(answer, -1);
        dfs(A);

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int[] A) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(A[N-1]);

        int num = 0;
        for (int i = N-2; i >= 0; i--) {
            while(!stack.isEmpty()){
                num = stack.pollLast();
                if (A[i] < num){
                    answer[i] = num;
                    break;
                }
            }

            stack.offerLast(num);
            stack.offerLast(A[i]);
        }
    }
}
