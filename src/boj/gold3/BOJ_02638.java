package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023/09/28
 * - @see https://www.acmicpc.net/problem/2638
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 */

public class BOJ_02638 {
    static int N, M;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Info> meltingCheese = new ArrayDeque<>();

    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] cheese = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                cheese[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Info> meltingCheese = new ArrayDeque<>();
        init(cheese, 0 , 0);
        System.out.println(bfs(cheese));
    }

    private static void init(int[][] cheese, int r, int c) {
        Queue<Info> air = new ArrayDeque<>();

        air.offer(new Info(r, c));
        cheese[0][0] = -1;

        int row, col, nr, nc;
        while (!air.isEmpty()) {
            Info info = air.poll();
            row = info.row;
            col = info.col;

            for (int i = 0; i < 4; i++) {
                nr = row + delta[i][0];
                nc = col + delta[i][1];
                if (isIn(nr, nc)) {
                    // 공기라면
                    if (cheese[nr][nc] == 0) {
                        cheese[nr][nc] = -1;
                        air.offer(new Info(nr, nc));
                    } else if (cheese[nr][nc] >= 1) {
                        cheese[nr][nc]++;
                        if (cheese[nr][nc] == 3) {
                            cheese[nr][nc] = -1;
                            meltingCheese.offer(new Info(nr, nc));
                        }
                    }
                }
            }
        }
    }

    private static int bfs(int[][] cheese) {
        int row, col, time = 0, nr, nc;
        while (!meltingCheese.isEmpty()) {
            int size = meltingCheese.size();
            time++;
            for (int k = 0; k < size; k++) {
                Info info = meltingCheese.poll();
                row = info.row;
                col = info.col;

                for (int i = 0; i < 4; i++) {
                    nr = row + delta[i][0];
                    nc = col + delta[i][1];
                    if (isIn(nr, nc)) {
                        // 공기라면
                        if (cheese[nr][nc] == 0) {
                            cheese[nr][nc] = -1;
                            init(cheese, nr, nc);
                        } else if (cheese[nr][nc] >= 1) {
                            cheese[nr][nc]++;
                            if (cheese[nr][nc] == 3) {
                                cheese[nr][nc] = -1;
                                meltingCheese.offer(new Info(nr, nc));
                            }
                        }
                    }
                }
            }

        }
        return time;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
