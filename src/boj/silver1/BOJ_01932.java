package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 10/1/2023
 * - @see https://www.acmicpc.net/problem/1932
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * 밑에서부터 역추적해서 올라오면서 큰 값을 저장해준다.
 */

public class BOJ_01932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        int[][] dp = new int[n+1][n+1];  // dp테이블은 패딩 조건을 이용해주기 위해 한 칸 더 크게 만들어준다. (점화식을 위해)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                dp[i-1][j] = Math.max(dp[i][j] + triangle[i-1][j], dp[i][j+1] + triangle[i-1][j]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
