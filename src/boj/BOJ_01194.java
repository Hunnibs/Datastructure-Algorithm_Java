package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-09-26
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note */

public class BOJ_01194 {
    static class Info{
        int row, col, dimension, time;

        public Info(int row, int col, int dimension, int time) {
            this.row = row;
            this.col = col;
            this.dimension = dimension;
            this.time = time;
        }
    }
    static int N, M;
    static boolean[][][] visited;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int row = 0, col = 0;
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == '0'){
                    row = r;
                    col = c;
                }
            }
        }

        // main
        visited = new boolean[64][N][M];

    }

    private static void bfs(char[][] map, int row, int col){
        int r, c, dim, time, nr, nc;
        Queue<Info> queue = new ArrayDeque<>();

        queue.offer(new Info(row, col, 0b000000, 0));
        visited[0][row][col] = true;

        while(!queue.isEmpty()){
            Info info = queue.poll();
            r = info.row;
            c = info.col;
            dim = info.dimension;
            time = info.time;
            for (int i = 0; i < 4; i++) {
                nr = r + delta[i][0];
                nc = c + delta[i][1];
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
