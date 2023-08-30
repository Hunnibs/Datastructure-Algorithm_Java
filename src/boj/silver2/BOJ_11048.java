package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-30
 * - @see https://www.acmicpc.net/problem/
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 */
public class BOJ_11048 {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] delta = {{0, 1}, {1, 0}, {1, 1}};
    static int N, M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        bfs(map, dp);
        System.out.println(dp[N-1][M-1]);
    }

    private static void bfs(int[][] map, int[][] dp){
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(0, 0));
        dp[0][0] = map[0][0];

        while(!queue.isEmpty()){
            Info current = queue.poll();
            for (int i = 0; i < 3; i++){
                int tr = current.row + delta[i][0];
                int tc = current.col + delta[i][1];
                if (isIn(tr, tc)){
                    if (dp[tr][tc] == -1){
                        dp[tr][tc] = dp[current.row][current.col] + map[tr][tc];
                        queue.offer(new Info(tr, tc));
                    } else if (dp[tr][tc] < dp[current.row][current.col] + map[tr][tc]){
                        dp[tr][tc] = dp[current.row][current.col] + map[tr][tc];
                        queue.offer(new Info(tr, tc));
                    }
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
