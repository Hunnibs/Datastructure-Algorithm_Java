package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-30
 * - @see https://www.acmicpc.net/problem/2294
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */
public class BOJ_02294 {
    final static int INF = 10001;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }


        Arrays.fill(dp, INF);

        dp[k] = 0;
        for(int coin : coins){
            for (int i = k; i >= 0 ; i--) {
                if (i - coin >= 0){
                    dp[i-coin] = Math.min(dp[i-coin], dp[i]+1);
                }
            }
        }
        if (dp[0] == INF){
            System.out.println(-1);
        } else {
            System.out.println(dp[0]);
        }
    }
}
