package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * - @author 이병헌
 * - @since 2023-08-29
 * - @see https://www.acmicpc.net/problem/1463
 * - @git
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming
 * - @note
 */
public class BOJ_01463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i < X+1; i++){
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }

            if (i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        System.out.println(dp[X]);
    }
}
