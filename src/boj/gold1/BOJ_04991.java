package boj.gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 10/7/2023
- @see https://www.acmicpc.net/problem/4991
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS # Bitmasking
- @note */

public class  BOJ_04991 {
    static class Info{
        int row, col, dim;

        public Info(int row, int col, int dim) {
            this.row = row;
            this.col = col;
            this.dim = dim;
        }
    }
    static int h, w, dirty;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0){
                break;
            }

            char[][] room = new char[h][w];
            Info[] infos = new Info[10];  // 더러운 칸은 10개를 넘지 않는다.
            Info start = null;

            int idx = 0;
            for (int r = 0; r < h; r++) {
                String s = br.readLine();
                for (int c = 0; c < w; c++) {
                    room[r][c] = s.charAt(c);

                    if (room[r][c] == 'o') {
                        start = new Info(r, c, 0);
                    } else if (room[r][c] == '*') {
                        infos[idx++] = new Info(r, c, 0);
                    }
                }
            }
            dirty = 0;
            for (int i = 0; i < idx; i++) {
                dirty |= (1 << i);
            }

            // main
            bfs(room, start, infos);
        }
        System.out.println(sb);
    }

    private static void bfs(char[][] room, Info start, Info[] infos){
        boolean[][][] visited = new boolean[0b1111111111][h][w];
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[0][start.row][start.col] = true;

        int idx, dim, nr, nc, time = 0, size;
        while(!queue.isEmpty()){
            time++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Info current = queue.poll();
                dim = current.dim;
                if (dim == dirty){  // 청소 끝!
                    sb.append(time-1).append("\n");
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    nr = current.row + delta[j][0];
                    nc = current.col + delta[j][1];
                    if (isIn(nr, nc) && !visited[dim][nr][nc]){
                        if (room[nr][nc] == '.' || room[nr][nc] == 'o'){
                            visited[dim][nr][nc] = true;
                            queue.offer(new Info(nr, nc, dim));
                        } else if (room[nr][nc] == '*'){
                            visited[dim][nr][nc] = true;
                            idx = find(infos, nr, nc);
                            queue.offer(new Info(nr, nc, (dim | (1 << idx))));
                        }
                    }
                }
            }
        }
        sb.append(-1).append("\n");
    }

    private static int find(Info[] infos, int row, int col){
        for (int i = 0; i < infos.length; i++) {
            if (row == infos[i].row && col == infos[i].col){
                return i;
            }
        }
        return -1;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < h && col >= 0 && col < w;
    }
}
