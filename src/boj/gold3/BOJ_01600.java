package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-30
 * - @see https://www.acmicpc.net/problem/1600
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 * 최단 경로 문제는 무조건 DFS가 아닌 BFS 사용할 것
 */
public class BOJ_01600 {
    static class Info{
        int row, col, count, depth;

        public Info(int row, int col, int count, int depth) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.depth = depth;
        }
    }

    static int[][] moveLikeHorse = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int[][] moveLikeMonkey = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int W, H;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());  // 말처럼 움직일 수 있는 횟수
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());  // 가로 길이
        H = Integer.parseInt(st.nextToken());  // 세로 길이

        int[][] map = new int[H][W];
        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        Info[][] visited = new Info[H][W];
        System.out.println(bfs(K, map, visited));
    }

    private static int bfs(int K, int[][] map, Info[][] visited){
        Queue<Info> queue = new ArrayDeque<>();
        visited[0][0] = new Info(0, 0, K, 0);
        queue.add(new Info(0, 0, K, 0));

        while(!queue.isEmpty()){
            Info current = queue.poll();
            if (current.row == H-1 && current.col == W-1){
                return current.depth;
            }

            int tr, tc;
            for (int i = 0 ; i < 4; i++){
                tr = current.row + moveLikeMonkey[i][0];
                tc = current.col + moveLikeMonkey[i][1];
                if (isIn(tr, tc) && map[tr][tc] != 1){
                    Info next = new Info(tr, tc, current.count, current.depth+1);
                    if (visited[tr][tc] == null) {
                        visited[tr][tc] = next;
                        queue.add(next);
                    } else if (visited[tr][tc].count < next.count){
                        visited[tr][tc] = next;
                        queue.add(next);
                    }
                }
            }

            if (current.count > 0) {
                for (int i = 0; i < 8; i++) {
                    tr = current.row + moveLikeHorse[i][0];
                    tc = current.col + moveLikeHorse[i][1];
                    if (isIn(tr, tc) && map[tr][tc] != 1) {
                        Info next = new Info(tr, tc, current.count-1, current.depth+1);
                        if (visited[tr][tc] == null) {
                            visited[tr][tc] = next;
                            queue.add(next);
                        } else if (visited[tr][tc].count < next.count) {
                            visited[tr][tc] = next;
                            queue.add(next);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < H && col >= 0 && col < W;
    }
}