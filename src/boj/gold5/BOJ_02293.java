package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-29
 * - @see https://www.acmicpc.net/problem/2293
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */
public class BOJ_02293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= k - coin; i++) {
                dp[i+coin] += dp[i];
            }
        }

        System.out.println(dp[k]);
    }
}
