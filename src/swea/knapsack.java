package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N+1][K+1];
            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                for (int c = 1; c <= K; c++) {
                    if (c < C){
                        dp[r][c] = dp[r-1][c];
                    } else{
                        dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-C] + V);
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
    }
}
