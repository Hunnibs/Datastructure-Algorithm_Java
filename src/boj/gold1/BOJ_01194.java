package boj.gold1;

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
        System.out.println(bfs(map, row, col));
    }

    private static int bfs(char[][] map, int row, int col){
        int r, c, dim, time, nr, nc, tmp;
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
                if(isIn(nr, nc) && !visited[dim][nr][nc]){
                    if (map[nr][nc] == '.' || map[nr][nc] == '0'){  // 그냥 이동할 수 있는 경우
                        visited[dim][nr][nc] = true;
                        queue.offer(new Info(nr, nc, dim, time+1));
                    } else if (map[nr][nc] == '1'){  // 목적지에 도착했다면 걸린 시간 출력
                        return time+1;
                    } else if (map[nr][nc] - 'A' >= 0 && map[nr][nc] - 'A' < 26){  // 대문자
                        if(check(map[nr][nc], dim)) {
                            visited[dim][nr][nc] = true;
                            queue.offer(new Info(nr, nc, dim, time+1));
                        }
                    } else if (map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' < 26){  // 소문자
                        visited[dim][nr][nc] = true;
                        tmp = update(map[nr][nc], dim);
                        visited[tmp][nr][nc] = true;
                        queue.offer(new Info(nr, nc, tmp, time+1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean check(char cmd, int dimension){
        boolean tmp = true;
        switch (cmd) {
            case 'A':
                if ((dimension & 1) == 1) {
                    tmp = true;
                } else {
                    tmp = false;
                }
                break;
            case 'B':
                if ((dimension & (1 << 1)) > 0) {
                    tmp = true;
                } else {
                    tmp = false;
                }
                break;
            case 'C':
                if ((dimension & (1 << 2)) > 0) {
                    tmp =  true;
                } else {
                    tmp =  false;
                }
                break;
            case 'D':
                if ((dimension & (1 << 3)) > 0) {
                    tmp =  true;
                } else {
                    tmp =  false;
                }
                break;
            case 'E':
                if ((dimension & (1 << 4)) > 0) {
                    tmp =  true;
                } else {
                    tmp =  false;
                }
                break;
            case 'F':
                if ((dimension & (1 << 5)) > 0) {
                    tmp =  true;
                } else {
                    tmp =  false;
                }
                break;
        }
        return tmp;
    }

    private static int update(char cmd, int dimension){
        switch (cmd){
            case 'a':
                dimension |= 1;
                break;
            case 'b':
                dimension |= (1 << 1);
                break;
            case 'c':
                dimension |= (1 << 2);
                break;
            case 'd':
                dimension |= (1 << 3);
                break;
            case 'e':
                dimension |= (1 << 4);
                break;
            case 'f':
                dimension |= (1 << 5);
                break;
        }

        return dimension;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
