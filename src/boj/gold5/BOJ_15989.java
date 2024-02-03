package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2/3/2024
 * - @see https://www.acmicpc.net/problem/15989
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # Dynamic Programming # Memorization
 * - @note
 */

public class BOJ_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10_001][3];
        makeSet(dp);

        for (int test_case = 0; test_case < T; test_case++) {
            int num = Integer.parseInt(br.readLine());

            int sum = dp[num][0] + dp[num][1] + dp[num][2];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    private static void makeSet(int[][] dp) {
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][2] = 1;

        for (int i = 4; i < 10_001; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][2] = dp[i - 3][2];
        }
    }
}
