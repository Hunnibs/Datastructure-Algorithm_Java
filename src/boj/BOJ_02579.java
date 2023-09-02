package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-09-01
 * - @see https://www.acmicpc.net/problem/2579
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */
public class BOJ_02579 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[1] = stairs[1];
        for (int i = 0; i <= N; i++) {
            if (i+3 <= N) {
                dp[i+3] = Math.max(dp[i+3], dp[i] + stairs[i+1] + stairs[i+3]);
            }

            if (i+2 <= N){
                dp[i+2] = Math.max(dp[i+2], dp[i] + stairs[i+2]);
            }
        }

        System.out.println(Math.max(dp[N], dp[N-1] + stairs[N]));
    }
}
