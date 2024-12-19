/**

- @author 이병헌
- @since 12/19/2024
- @see https://www.acmicpc.net/problem/1726
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 128MB
- @category # BFS
- @note
0 < M, N <= 100
 */

import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 동, 남, 서, 북

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Info start = new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, setDir(Integer.parseInt(st.nextToken())), 0);
        st = new StringTokenizer(br.readLine());
        Info end = new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, setDir(Integer.parseInt(st.nextToken())),0);

        System.out.print(bfs(start, end, map));
    }

    private static int bfs(Info start, Info end, int[][] map) {
        Queue<Info> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[4][N][M];
        queue.add(start);

        while(!queue.isEmpty()) {
            Info cur = queue.poll();

            if (isFinish(end, cur.r, cur.c, cur.dir)) return cur.order;

            // change direction
            for (int dir = 1; dir <= 2; dir++) {
                int turnD = turnDir(cur, dir);
                if (!visited[turnD][cur.r][cur.c]) {
                    visited[turnD][cur.r][cur.c] = true;
                    queue.offer(new Info(cur.r, cur.c, turnD, cur.order+1));
                }
            }

            // move
            for (int k = 1; k <= 3; k++) {
                int nr = cur.r + (delta[cur.dir][0] * k);
                int nc = cur.c + (delta[cur.dir][1] * k);

                if (isIn(nr, nc) && !visited[cur.dir][nr][nc]) {
                    if (!isOrbit(map, nr, nc)) break;

                    visited[cur.dir][nr][nc] = true;
                    queue.offer(new Info(nr, nc, cur.dir, cur.order + 1));
                }
            }
        }

        return 0;
    }

    private static int turnDir(Info cur, int dir) {
        switch(dir) {
            case 1:  // 왼쪽
                return (cur.dir + 3) % 4;
            case 2:  // 오른쪽
                return (cur.dir + 1) % 4;
            default:
                return cur.dir;
        }
    }

    private static boolean isFinish(Info end, int r, int c, int dir) {
        return end.r == r && end.c == c && end.dir == dir;
    }

    private static boolean isOrbit(int[][] map, int r, int c) {
        if (map[r][c] == 0) return true;
        else return false;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static int setDir(int dir) {
        switch(dir) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
        }

        return 0;
    }

    private static class Info{
        int r;
        int c;
        int dir;
        int order;

        public Info(int r, int c, int dir, int order) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.order = order;
        }
    }
}