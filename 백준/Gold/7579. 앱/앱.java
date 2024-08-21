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

        PriorityQueue<Info> apps = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        for(int i = 0; i < N; i++){
            apps.add(new Info(memories[i], costs[i]));
        }

        knapsack(N, M, apps);
    }

    private static void knapsack(int N, int M, PriorityQueue<Info> apps){
        int[][] dp = new int[N+1][10_001];
        int ans = 10_000_000;

        for(int i = 1; i <= N; i++){
            Info cur = apps.poll();
            dp[i][cur.cost] = cur.memory;
            for(int j = 0; j <= 10_000; j++){
                if (j < cur.cost){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cur.cost] + cur.memory);
                }

                if (dp[i][j] >= M) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.print(ans);
    }

    private static class Info{
        int memory, cost;

        public Info(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }
}