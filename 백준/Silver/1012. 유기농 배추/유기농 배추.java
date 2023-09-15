import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/14
- @see https://www.acmicpc.net/problem/BOJ_01012
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note */

public class Main {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, M;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            boolean[][] visited = new boolean[N][M];
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 1 && !visited[r][c]){
                        bfs(map, r, c, visited);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int[][] map, int row, int col, boolean[][] visited){
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Info current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current.row + delta[i][0];
                int nc = current.col + delta[i][1];

                if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.offer(new Info(nr, nc));
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}