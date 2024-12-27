/**

- @author 이병헌
- @since 12/27/2024
- @see https://www.acmicpc.net/problem/14923
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note

 */

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(bfs(map, Hx, Hy, Ex, Ey));
    }

    private static int bfs(int[][] map, int Hx, int Hy, int Ex, int Ey) {
        Queue<Info> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][N][M];
        queue.offer(new Info(Hx, Hy, false));
        visited[0][Hx][Hy] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Info cur = queue.poll();

                if (cur.r == Ex && cur.c == Ey) return count;

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + delta[i][0];
                    int nc = cur.c + delta[i][1];

                    if (isIn(nr, nc)){
                        if (cur.magic) {
                            if (map[nr][nc] == 0 && !visited[1][nr][nc]){
                                visited[1][nr][nc] = true;
                                queue.offer(new Info(nr, nc, true));
                            }
                        } else{
                            if (!visited[0][nr][nc]) {
                                if (map[nr][nc] == 0) {
                                    visited[0][nr][nc] = true;
                                    queue.offer(new Info(nr, nc, false));
                                } else {
                                    visited[1][nr][nc] = true;
                                    queue.offer(new Info(nr, nc, true));
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static boolean canGo(int[][] map, int r, int c) {
        return map[r][c] == 0;
    }

    private static class Info {
        int r, c;
        boolean magic;

        public Info(int r, int c, boolean magic) {
            this.r = r;
            this.c = c;
            this.magic = magic;
        }
    }
}