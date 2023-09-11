package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-09-11
- @see https://www.acmicpc.net/problem/BOJ_01245
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # DFS # BFS
- @note

 */

public class BOJ_01245 {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static boolean[][] visited;
    static int[][] mountain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int height = 0;
        mountain = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                mountain[r][c] = Integer.parseInt(st.nextToken());
                if (mountain[r][c] > height){
                    height = mountain[r][c];
                }
            }
        }

        int answer = 0;
        while (height > 0){
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && mountain[r][c] == height){
                        visited[r][c] = true;
                        search(r, c);
                        answer++;
                    }
                }
            }

            height--;
        }

        System.out.println(answer);
    }

    private static void search(int row, int col){
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(row, col));

        // Heght에 인접한 영역들을 지정
        while(!queue.isEmpty()){
            Info current = queue.poll();
            int r = current.row;
            int c = current.col;

            for (int i = 0; i < 8; i++) {
                int tr = current.row + delta[i][0];
                int tc = current.col + delta[i][1];
                if(isIn(tr, tc) && !visited[tr][tc] && mountain[tr][tc] <= mountain[r][c]){
                    visited[tr][tc] = true;
                    queue.offer(new Info(tr, tc));
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}