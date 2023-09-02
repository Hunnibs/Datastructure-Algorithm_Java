package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-30
 * - @see https://www.acmicpc.net/problem/1010
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming
 * - @note
 * 이항계수 문제
 * 시간이 0.5초밖에 안 주어졌으므로 Dynamic programming 기법을 이용해 점화식을 세워 문제를 해결한다.
 */
public class BOJ_01010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tets_case = 1; tets_case <= T; tets_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M+1][N+1];
            for (int i = 0; i <= M; i++) {
                for (int j = 0; j <= Math.min(i, N); j++) {
                    if (j == 0 || j == i) {
                        dp[i][j] = 1;
                    } else{
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }
                }
            }

            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}
