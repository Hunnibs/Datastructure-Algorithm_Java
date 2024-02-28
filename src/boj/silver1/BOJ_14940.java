package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/15/24
- @see https://www.acmicpc.net/problem/14940
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 128MB
- @category # BFS
- @note */

public class BOJ_14940 {
    private static final int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Info start = new Info(0, 0);
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2){
                    start = new Info(r, c);
                }
            }
        }

        // input end
        sol(n, m, map, start);
    }

    private static void sol(int n, int m, int[][] map, Info start) {
        int[][] answer = new int[n][m];
        bfs(n, m, map, answer, start);
        fill(n, m, map, answer);
        print(answer);
    }

    private static void fill(int n, int m, int[][] map, int[][] answer){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && answer[i][j] == 0){
                    answer[i][j] = -1;
                }
            }
        }
    }

    private static int[][] bfs(int n, int m, int[][] map, int[][] answer, Info start) {
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(start);

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Info cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + delta[j][0];
                    int nc = cur.c + delta[j][1];

                    if (isIn(n, m, nr, nc) && map[nr][nc] == 1 && answer[nr][nc] == 0){
                        answer[nr][nc] = distance;
                        queue.offer(new Info(nr, nc));
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isIn(int n, int m, int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static void print(int[][] answer) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static class Info{
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
