package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * - @author 이병헌
 * - @since 2023-08-29
 * - @see https://www.acmicpc.net/problem/11726
 * - @git
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming
 * - @note
 *
 */
public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if (N <= 2){
            System.out.println(N);
        } else{
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= N; i++){
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            }

            System.out.println(dp[N]);
        }
    }
}
