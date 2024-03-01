package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**

 - @author 이병헌
 - @since 3/1/2024
 - @see https://www.acmicpc.net/problem/18430
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance 2sec 256MB
 - @category # DFS
 - @note

 */

public class BOJ_18430 {
    private static int[][][] boomerang = {
            {{1, 0}, {0, -1}},
            {{-1, 0}, {0, -1}},
            {{-1, 0}, {0, 1}},
            {{1, 0}, {0, 1}}
    };
    private static int N, M;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, visited, 0,  0);

        System.out.print(answer);
    }

    private static void dfs(int[][] board, boolean[][] visited, int row, int sum){
        for (int r = row; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]){
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int[][] piece = boomerang[i];
                    int nr1 = r + piece[0][0];
                    int nc1 = c + piece[0][1];
                    int nr2 = r + piece[1][0];
                    int nc2 = c + piece[1][1];

                    if (isIn(nr1, nc1) && isIn(nr2, nc2) && !visited[nr1][nc1] && !visited[nr2][nc2]) {
                        visited[r][c] = true;
                        visited[nr1][nc1] = true;
                        visited[nr2][nc2] = true;
                        dfs(board, visited, r, sum + (board[r][c] * 2) + board[nr1][nc1] + board[nr2][nc2]);
                        visited[r][c] = false;
                        visited[nr1][nc1] = false;
                        visited[nr2][nc2] = false;
                    }
                }
            }
        }

        answer = Math.max(answer, sum);
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    private static class Pos{
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
