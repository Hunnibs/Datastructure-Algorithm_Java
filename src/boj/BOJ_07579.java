package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/20
- @see https://www.acmicpc.net/problem/7579
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Dynamic Progr
- @note */

public class BOJ_07579 {
    static class Info{
        int memory, cost;

        public Info(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "memory=" + memory +
                    ", cost=" + cost +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringTokenizer st2;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                 if (o1.cost != o2.cost){
                     return o1.cost - o2.cost;
                 } else{
                     return o2.memory - o1.memory;
                 }
            }
        });

        int max = 0;
        int memory = 0;
        int cost = 0;
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st2.nextToken());
            pq.offer(new Info(memory, cost));
            max += cost;
        }

        // main
        int[][] dp = new int[N+1][M+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], max);
        }
        dp[0][0] = 0;
        for (int i = 1; i < N+1; i++) {
            Info select = pq.poll();
            memory = select.memory;
            cost = select.cost;
            for (int j = 0; j <= M; j++) {
                if (j - memory >= 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-memory] + cost);
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
