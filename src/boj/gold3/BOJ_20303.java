package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2024-02-27
 * - @see https://www.acmicpc.net/problem/20303
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 1024MB
 * - @category # Union-Find
 * - @note
 */

public class BOJ_20303 {
    private static int N, M, K;
    private static int[] candy, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // candy 가진 수
        st = new StringTokenizer(br.readLine());
        candy = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }
        // input end

        for (int i = 1; i <= N; i++) {
            parent[i] = find(parent[i]);
        }

        sol();
    }

    private static void sol() {
        int[] totalCandy = new int[N + 1];
        int[] size = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            totalCandy[parent[i]] += candy[i];  // 경로 압축을 해서 Union-find를 완료했으므로 총 candy = 부모 노드에 + candy
            size[parent[i]]++;
        }

        System.out.println(knapSack(totalCandy, size));
    }

    private static int knapSack(int[] totalCandy, int[] size) {
        int[][] dp = new int[N + 1][K];

        for (int i = 1; i <= N; i++) {
            int tc = totalCandy[i];  // total candy
            int fs = size[i];  // friend size

            for (int j = 1; j < K; j++) {
                if (j < fs) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - fs] + tc);
                }
            }
        }

        return dp[N][K-1];
    }

    // union-find
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
