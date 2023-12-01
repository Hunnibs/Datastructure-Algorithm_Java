package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

 - @author 이병헌
 - @since 11/26/23
 - @see https://www.acmicpc.net/problem/17485
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance
 - @category #
 - @note
 N * M 행렬 아래로만 움직일 수 있으며 좌대각, 아래, 우대각이 가능 -> 단, 한 번 움직인 방향으로는 움직일 수 없다.
 DFS 알고리즘을 통해 해결할 예정
 depth 이동 시 필요 parameter => 현재 위치 관련, 방향 정보,
 */

public class BOJ_17484 {
    private static int[][] delta = {{1, -1}, {1, 0}, {1, 1}};  // 좌, 아래, 우
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력
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

        System.out.println(dfs(map));
    }

    private static int dfs(int[][] map){
        Deque<Info> infos = new ArrayDeque<>();  // DFS 사용을 위한 stack 자료구조
        int answer = Integer.MAX_VALUE;  // 최대 크기를 지정한 후 줄여가는 방식 활용할 예정

        for (int i = 0; i < M; i++) {  // 0번 행의 값들을 미리 넣어줌
            infos.offerLast(new Info(0, i, -1, map[0][i]));
        }

        while(!infos.isEmpty()){
            Info info = infos.pollLast();

            for (int i = 0; i < 3; i++) {
                if (info.dir == i) { // 같은 방향으로 이동이 불가하므로 skip
                    continue;
                }

                int nr = info.row + delta[i][0];
                int nc = info.col + delta[i][1];
                if (isIn(nr, nc) && info.sum + map[nr][nc] < answer && info.row < N-2) {
                    infos.offerLast(new Info(nr, nc, i, info.sum + map[nr][nc]));
                }

                // 마지막 행일 경우
                if (isIn(nr, nc) && info.sum + map[nr][nc] < answer && info.row == N - 2) {
                    answer = info.sum + map[nr][nc];
                }
            }
        }

        return answer;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    private static class Info{
        int row, col, dir, sum;

        public Info(int row, int col, int dir, int sum) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.sum = sum;
        }
    }
}