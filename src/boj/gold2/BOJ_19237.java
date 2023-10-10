package boj.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 10/9/2023
- @see https://www.acmicpc.net/problem/19237
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note */

public class BOJ_19237 {
    static class Shark{
        int row, col, dir;

        public Shark(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    static int N, M, K;
    static int[][] delta = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Shark[] sharks = new Shark[M+1];
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0){
                    sharks[map[r][c]] = new Shark(r, c, 0);
                }
            }
        }

        // 현재 진행방향 설정
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken());
        }

        // 각 상어당 우선순위 이동방향
        int[][][] priority = new int[M+1][4][4];
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs(map, sharks, priority));
    }

    private static int bfs(int[][] map, Shark[] sharks, int[][][] priority) {
        int[][][] sharkSmell = new int[M+1][N][N];
        int[][] allSharkSmell = new int[N][N];

        int time = 0;
        while (time < 1001) {
            time++;
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println("--------------------------");
            if (allDie(sharks)){
                return time-1;
            }
            for (int i = 1; i <= M; i++) {  // 향을 남기고 시작
                Shark shark = sharks[i];
                if (shark.dir != 0) {  // 방향이 0인 상어는 죽은 상어
                    allSharkSmell[shark.row][shark.col] = time;
                    sharkSmell[i][shark.row][shark.col] = time;
                }
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(allSharkSmell[i]));
//            }
//            System.out.println("--------------------------");
            for (int i = 1; i <= M; i++) {
                Shark shark = sharks[i];
                if (shark.dir != 0) {  // 방향이 0인 상어는 죽은 상어
                    int dir = checkDirection(shark, map, sharkSmell, allSharkSmell, priority, i, time);
                    move(shark, map, dir, i);
                }
            }
        }
        return -1;
    }

    private static boolean allDie(Shark[] sharks) {
        for (int i = 2; i <= M; i++) {
            if (sharks[i].dir != 0){
                return false;
            }
        }
        return true;
    }

    private static void move(Shark shark, int[][] map, int dir, int idx) {
        int nr = shark.row + delta[dir][0];
        int nc = shark.col + delta[dir][1];

        if (map[nr][nc] == 0){
            map[shark.row][shark.col] = 0;
            map[nr][nc] = idx;
            shark.dir = dir;
        } else if (map[nr][nc] > idx){  // 이동
            map[shark.row][shark.col] = 0;
            map[nr][nc] = idx;
            shark.dir = dir;
        } else if (map[nr][nc] < idx){  // 상어 주금
            map[shark.row][shark.col] = 0;
            shark.dir = 0;
        }
        shark.row = nr;
        shark.col = nc;
    }

    private static int checkDirection(Shark shark, int[][] map, int[][][] sharkSmell, int[][] allSharkSmell, int[][][] priority, int idx, int time) {
        int dir, nr, nc;
        for (int i = 0; i < 4; i++) {
            dir = priority[idx][shark.dir-1][i];
            nr = shark.row + delta[dir][0];
            nc = shark.col + delta[dir][1];

            if (isIn(nr, nc) && allSharkSmell[nr][nc] == 0){
                return dir;
            } else if (isIn(nr, nc) && time >= allSharkSmell[nr][nc] + K){
                return dir;
            }
        }

        // 모든 방향에 냄새가 퍼져있다면
        return findMySmell(shark, sharkSmell, priority, idx, time);
    }

    private static int findMySmell(Shark shark, int[][][] sharkSmell, int[][][] priority, int idx, int time) {
        int nr, nc, dir;
        for (int i = 0; i < 4; i++) {
            dir = priority[idx][shark.dir-1][i];
            nr = shark.row + delta[dir][0];
            nc = shark.col + delta[dir][1];
            if (isIn(nr, nc) && sharkSmell[idx][nr][nc] != 0 && time < sharkSmell[idx][nr][nc] + K ){
                return dir;
            }
        }

        if (shark.dir == 1 || shark.dir == 3) {
            return shark.dir + 1;
        } else {
            return shark.dir - 1;
        }

    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
