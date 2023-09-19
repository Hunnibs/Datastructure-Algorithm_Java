package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-09-18
- @see https://www.acmicpc.net/problem/2636
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note */

public class BOJ_02636 {
    static class Info{
        int row, col, time;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Info(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    static int n, m;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Info> mainQ = new ArrayDeque<>();
    static List<Integer> times = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] cheese = new int[n+2][m+2];
        boolean[][] visited = new boolean[n+2][m+2];
        for (int r = 1; r < n+1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < m + 1; c++) {
                cheese[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        padding(cheese, visited);
        init(cheese, visited);
        corrosion(cheese, visited);

        System.out.println(times.size());
        System.out.println(times.get(times.size()-1));
    }

    private static void corrosion(int[][] cheese, boolean[][] visited){
        int tr, tc, time;
        while(!mainQ.isEmpty()) {
            Info current = mainQ.poll();
            time = current.time;

            if (times.size() == time){
                times.add(1);
            } else if (times.size() > time){
                times.set(time, times.get(time)+1);
            }

            for (int i = 0; i < 4; i++) {
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 1){
                    visited[tr][tc] = true;
                    mainQ.offer(new Info(tr, tc, time+1));
                }

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 0){
                    visited[tr][tc] = true;
                    airInjection(cheese, visited, tr, tc, current.time+1);
                }
            }
        }
    }

    private static void airInjection(int[][] cheese, boolean[][] visited, int row, int col, int time) {
        Queue<Info> queue = new ArrayDeque<>();

        queue.offer(new Info(row, col, time));
        int tr, tc;
        while(!queue.isEmpty()){
            Info current = queue.poll();

            for (int i = 0; i < 4; i++) {
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 0){
                    cheese[tr][tc] = 2;
                    visited[tr][tc] = true;
                    queue.offer(new Info(tr, tc, time));
                }

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 1){
                    visited[tr][tc] = true;
                    mainQ.offer(new Info(tr, tc, time));
                }
            }
        }
    }

    private static void init(int[][] cheese, boolean[][] visited) {
        Queue<Info> queue = new ArrayDeque<>();
        for (int r = 0; r < n + 2; r++) {
            for (int c = 0; c < m + 2; c++) {
                if (cheese[r][c] == 2) {
                    queue.offer(new Info(r, c));
                }
            }
        }

        int tr, tc;
        while(!queue.isEmpty()){
            Info current = queue.poll();

            for (int i = 0; i < 4; i++) {
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 0){
                    cheese[tr][tc] = 2;
                    visited[tr][tc] = true;
                    queue.offer(new Info(tr, tc));
                }

                if (isIn(tr, tc) && !visited[tr][tc] && cheese[tr][tc] == 1){
                    visited[tr][tc] = true;
                    mainQ.offer(new Info(tr, tc, 0));
                }
            }
        }
    }

    private static void padding(int[][] cheese, boolean[][] visited){
        for (int i = 0; i < n+2; i++) {
            cheese[i][0] = 2;
            cheese[i][m+1] = 2;

            visited[i][0] = true;
            visited[i][m+1] = true;
        }

        for (int i = 0; i < m+2; i++) {
            cheese[0][i] = 2;
            cheese[n+1][0] = 2;

            visited[0][i] = true;
            visited[n+1][0] = true;
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < n+2 && col >= 0 && col < m+2;
    }
}
