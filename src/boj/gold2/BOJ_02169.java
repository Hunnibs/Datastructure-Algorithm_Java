package boj.gold2;

/**

- @author 이병헌
- @since 11/20/2024
- @see https://www.acmicpc.net/problem/2169
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # DFS
- @note
욕심쟁이 판다랑 비슷한 기억이 나지만 풀이는 기억나지 않는다.
 일단 DFS
 */

import java.util.*;
import java.io.*;

public class BOJ_02169 {
    private static int MIN_VALUE = -1_000_001;
    private static int[][] delta = {{0, -1}, {0, 1}, {1, 0}};
    private static int N, M;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        dp = new int[N][M];
        for (int r = 0; r < N; r++) Arrays.fill(dp[r], MIN_VALUE);

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        dp[0][0] = map[0][0];

        int r = 0, c = 0;
        visited[r][c] = true;
        dfs(map, visited, r, c);

        System.out.println(dp[N-1][M-1]);
    }

    private static void dfs(int[][] map, boolean[][] visited, int r, int c){
        int nr, nc;

        for (int i = 0; i < 3; i++){
            nr = r + delta[i][0];
            nc = c + delta[i][1];

            if (isIn(nr, nc) && !visited[nr][nc]){
                if (dp[r][c] + map[nr][nc] > dp[nr][nc]) {
                    visited[nr][nc] = true;
                    dp[nr][nc] = dp[r][c] + map[nr][nc];
                    dfs(map, visited, nr, nc);
                    visited[nr][nc] = false;
                }
            }
        }
    }



    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
