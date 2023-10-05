package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-10-05
 * - @see https://www.acmicpc.net/problem/4485
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */

public class BOJ_04485 {
    static class Info {
        int col, row;

        public Info(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    final static int MAX = Integer.MAX_VALUE;
    static int N;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] cave = new int[N][N];
            int[][] dp = new int[N][N];
            for (int c = 0; c < N; c++) {
                st = new StringTokenizer(br.readLine());
                for (int r = 0; r < N; r++) {
                    cave[c][r] = Integer.parseInt(st.nextToken());
                    dp[c][r] = MAX;
                }
            }

            sb.append("Problem " + T++ + ": " + bfs(cave, dp) + "\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int[][] cave, int[][] dp) {
        Queue<Info> queue = new ArrayDeque<>();

        queue.offer(new Info(0, 0));
        dp[0][0] = cave[0][0];

        int nc, nr, c, r;
        while (!queue.isEmpty()) {
            Info current = queue.poll();
            c = current.col;
            r = current.row;
            for (int i = 0; i < 4; i++) {
                nc = c + delta[i][0];
                nr = r + delta[i][1];

                if (isIn(nc, nr)) {
                    if (dp[nc][nr] > dp[c][r] + cave[nc][nr]) {
                        dp[nc][nr] = dp[c][r] + cave[nc][nr];
                        queue.offer(new Info(nc, nr));
                    }
                }
            }
        }

        return dp[N - 1][N - 1];
    }

    private static boolean isIn(int col, int row) {
        return col >= 0 && col < N && row >= 0 && row < N;
    }
}
