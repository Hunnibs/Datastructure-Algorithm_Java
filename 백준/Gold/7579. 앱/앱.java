/**

- @author 이병헌
- @since 8/21/24
- @see https://www.acmicpc.net/problem/7579
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Dynamic Programming # 0/1 Knapsack
- @note

 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memories[i] = Integer.parseInt(st.nextToken());
        }
        int[] costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        knapsack(N, M, costs, memories);
    }

    private static void knapsack(int N, int M, int[] costs, int[] memories){
        int[][] dp = new int[N+1][10_001];
        int ans = 10_000_000;

        for(int i = 1; i <= N; i++){
            dp[i][costs[i-1]] = memories[i-1];
            for(int j = 0; j <= 10_000; j++){
                if (j < costs[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i-1]] + memories[i-1]);
                }

                if (dp[i][j] >= M) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.print(ans);
    }
}