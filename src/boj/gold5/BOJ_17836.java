package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/13
- @see https://www.acmicpc.net/problem/BOJ_17836
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note
 BFS 최단경로 문제
 단, 특정 조건 칼을 얻는다면 벽이라는 제약조건조차 없어진다.
 */

public class BOJ_17836 {
    static class Info{
        int row, col, time;
        boolean haveSword;


        public Info(int row, int col, int time, boolean haveSword) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.haveSword = haveSword;
        }
    }
    static int N, M, T;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] castleMap = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                castleMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //main
        int answer = bfs(castleMap);

        if (answer == -1){
            System.out.println("Fail");
        } else{
            System.out.println(answer);
        }
    }

    private static int bfs(int[][] castleMap){
        boolean[][] visited = new boolean[N][M];
        boolean[][] newVisited = new boolean[N][M];
        Queue<Info> queue = new ArrayDeque<>();

        queue.offer(new Info(0, 0, 0, false));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Info current = queue.poll();
            // 승리 조건
            if (current.row == N-1 && current.col == M-1){
                return current.time;
            }
            // 패배 조건
            if (current.time == T){
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.row + delta[i][0];
                int nc = current.col + delta[i][1];
                boolean sword = current.haveSword;

                if (!sword) {  // 칼이 없으면
                    if (isIn(nr, nc) && !visited[nr][nc]) {
                        if (castleMap[nr][nc] == 2) {  // 검을 줍게 되는 경우
                            queue.offer(new Info(nr, nc, current.time + 1, true));
                            newVisited[nr][nc] = true;
                        } else {  // 그냥 이동하는 경우
                            if (castleMap[nr][nc] != 1) {
                                queue.offer(new Info(nr, nc, current.time + 1, false));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                } else{
                    if (isIn(nr, nc) && !newVisited[nr][nc]){
                        queue.offer(new Info(nr, nc, current.time+1, true));
                        newVisited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
