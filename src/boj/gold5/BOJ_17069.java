package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-10-12
- @see https://www.acmicpc.net/problem/17069
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @note */

public class BOJ_17069 {
    static class Info{
        int dir, val;

        public Info(int dir, int val) {
            this.dir = dir;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "dir=" + dir +
                    ", val=" + val +
                    '}';
        }
    }
    static int[][] delta = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs(){
        long[][][] dp = new long[4][N+1][N+1];
        dp[1][1][2] = 1;

        for (int r = 1; r <= N; r++) {
            for (int c = 2; c <= N; c++) {
                for (int dir = 1; dir < 4; dir++) {
                    if (map[r][c] != 1 && dp[dir][r][c] != 0){
                        update(dp, r, c, dir);
                    }
                }
            }
        }

        print(dp);
    }

    private static void print(long[][][] dp) {
        long answer = 0;
        for (int i = 1; i < 4; i++) {
            answer += dp[i][N][N];
        }
        System.out.println(answer);
    }

    private static void update(long[][][] dp, int r, int c, int dir) {
        int nr, nc;
        if (dir == 1){
            for (int i = 1; i < 3; i++) {
                nr = r + delta[i][0];
                nc = c + delta[i][1];

                if (isIn(nr, nc) && !isWall(nr, nc)){
                    if (i == 2){
                        if (map[r][nc] == 1) {
                            continue;
                        } else if(map[nr][c] == 1){
                            continue;
                        }
                    }
                    dp[i][nr][nc] = dp[i][nr][nc] + dp[dir][r][c];
                }
            }
        } else if (dir == 2){
            for (int i = 1; i < 4; i++) {
                nr = r + delta[i][0];
                nc = c + delta[i][1];

                if (isIn(nr, nc) && !isWall(nr, nc)){
                    if (i == 2){
                        if (map[r][nc] == 1) {
                            continue;
                        } else if(map[nr][c] == 1){
                            continue;
                        }
                    }
                    dp[i][nr][nc] = dp[i][nr][nc] + dp[dir][r][c];
                }
            }
        } else if (dir == 3){
            for (int i = 2; i < 4; i++) {
                nr = r + delta[i][0];
                nc = c + delta[i][1];

                if (isIn(nr, nc) && !isWall(nr, nc)){
                    if (i == 2){
                        if (map[r][nc] == 1) {
                            continue;
                        } else if(map[nr][c] == 1){
                            continue;
                        }
                    }
                    dp[i][nr][nc] = dp[i][nr][nc] + dp[dir][r][c];
                }
            }
        }
    }

    private static boolean isWall(int row, int col){
        return map[row][col] == 1;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row <= N && col >= 0 && col <= N;
    }
}
