package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-09-27
 * - @see https://www.acmicpc.net/problem/11404
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Floyd warshall
 * - @note
 */

public class BOJ_11404 {
    static final int MAX = 99_999_999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int start, end, cost;
        int[][] floyd = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(floyd[i], MAX);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            floyd[start][end] = Math.min(floyd[start][end], cost);
        }

        // main
        for (int via = 1; via < n + 1; via++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j){
                        continue;
                    }
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][via] + floyd[via][j]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (floyd[i][j] == MAX){
                    sb.append(0 + " ");
                } else{
                    sb.append(floyd[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
