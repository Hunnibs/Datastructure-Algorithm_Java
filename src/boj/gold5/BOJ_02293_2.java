package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 3/3/2024
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance 0.5sec 4MB
- @category # Dynmaic Programming
- @note */

public class BOJ_02293_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = num; j <= k; j++) {
                dp[j] += dp[j-num];
            }
        }
        System.out.println(dp[k]);
    }
}
