package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 12/22/2023
 * - @see https://www.acmicpc.net/problem/22342
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2sec 1024MB
 * - @category #
 * - @note
 */

public class BOJ_22342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] weight = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            String S = br.readLine();
            for (int j = 1; j <= n; j++) {
                weight[i][j] = S.charAt(j-1) - '0';
            }
        }

        // input end
        int max = 0;  // 저장값들 중 최대를 저장해줄 변수
        int save = 0;
        int[][] output = new int[m+2][n+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = -1; k <= 1; k++) {
                    save = Math.max(save, output[j+k][i-1]);
                }
                output[j][i] = save + weight[j][i];
                max = Math.max(save, max);
                save = 0;
            }
        }

        System.out.println(max);
    }
}
