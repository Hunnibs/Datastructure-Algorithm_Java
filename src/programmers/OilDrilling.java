import java.util.*;

class Solution {
    private static int N;
    private static int M;
    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] land) {
        int answer = 0;

        N = land.length;
        M = land[0].length;

        boolean[][] visited = new boolean[N][M];
        int[][] updateVisited = new int[N][M];
        int idx = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && land[r][c] == 1) {
                    dfs(land, visited, r, c);
                    dfsUpdate(land, updateVisited, r, c, land[r][c], idx++);
                }
            }
        }

        for (int c = 0; c < M; c++) {
            boolean[] check = new boolean[idx];
            int sum = 0;
            for (int r = 0; r < N; r++){
                if (land[r][c] > 0 && !check[updateVisited[r][c]]) {
                    sum += land[r][c];
                    check[updateVisited[r][c]] = true;
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private static int dfs(int[][] land, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (isin(nr, nc) && !visited[nr][nc] && land[nr][nc] == 1) {
                land[r][c] += dfs(land, visited, nr, nc);
            }

        }

        return land[r][c];
    }

    private static void dfsUpdate(int[][] land, int[][] visited, int r, int c, int size, int idx) {
        visited[r][c] = idx;
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (isin(nr, nc) && visited[nr][nc] == 0 && land[nr][nc] != 0) {
                land[nr][nc] = size;
                dfsUpdate(land, visited, nr, nc, size, idx);
            }
        }
    }

    private static boolean isin(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}