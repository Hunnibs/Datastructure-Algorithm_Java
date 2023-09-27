package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-09-27
- @see https://www.acmicpc.net/problem/3055
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note */

public class BOJ_03055 {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int R, C;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        List<Info> water = new ArrayList<>();
        Info start = null;
        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c);
                if(map[r][c] == 'S'){
                    start = new Info(r, c);
                } else if (map[r][c] == '*'){
                    water.add(new Info(r, c));
                }
            }
        }

        int result = bfs(map, water, start);

        if (result == -1){
            System.out.println("KAKTUS");
        } else{
            System.out.println(result);
        }
    }

    private static int bfs(char[][] map, List<Info> water, Info start) {
        boolean[][] visited = new boolean[R][C];
        Queue<Info> queue = new ArrayDeque<>();

        Queue<Info> waters = new ArrayDeque<>();
        for (int i = 0; i < water.size(); i++) {
            waters.offer(water.get(i));
        }

        visited[start.row][start.col] = true;
        queue.offer(new Info(start.row, start.col));

        int nr, nc, time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            spreadWater(map, waters);
            for (int i = 0; i < size; i++) {
                Info info = queue.poll();
                for (int j = 0; j < 4; j++) {
                    nr = info.row + delta[j][0];
                    nc = info.col + delta[j][1];

                    if (isIn(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]){
                        queue.offer(new Info(nr, nc));
                        visited[nr][nc] = true;
                    } else if(isIn(nr, nc) && map[nr][nc] == 'D'){
                        return time;
                    }
                }
            }
        }

        return -1;
    }

    private static Queue<Info> spreadWater(char[][] map, Queue<Info> waters) {
        int nr, nc;
        int size = waters.size();
        for (int i = 0; i < size; i++) {
            Info info = waters.poll();
            for (int j = 0; j < 4; j++) {
                nr = info.row + delta[j][0];
                nc = info.col + delta[j][1];
                if (isIn(nr, nc) && map[nr][nc] == '.'){
                    map[nr][nc] = '*';
                    waters.offer(new Info(nr, nc));
                }
            }
        }

        return waters;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
