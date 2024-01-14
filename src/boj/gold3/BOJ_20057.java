package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2024-01-12
 * - @see https://www.acmicpc.net/problem/20057
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # Implementation # Simulation
 * - @note
 */

public class BOJ_20057 {
    private static final int[][] delta = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static final int[][][] loc = {
            {{-1, 1}, {-1, 0}, {-2, 0}, {-1, -1}, {0, -2}, {1, -1}, {1, 0}, {2, 0}, {1, 1}, {0, -1}},
            {{-1, -1}, {0, -1}, {0, -2}, {1, -1}, {2, 0}, {1, 1}, {0, 1}, {0, 2}, {-1, 1}, {1, 0}},
            {{-1, -1}, {-1, 0}, {-2, 0}, {-1, 1}, {0, 2}, {1, 1}, {1, 0}, {2, 0}, {1, -1}, {0, 1}},
            {{1, -1}, {0, -1}, {0, -2}, {-1, -1}, {-2, 0}, {-1, 1}, {0, 1}, {0, 2}, {1, 1}, {-1, 0}}
    };
    private static final double[] percent = {0.01, 0.07, 0.02, 0.10, 0.05, 0.10, 0.07, 0.02, 0.01};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // input end
        sol(N, map);
    }

    private static void sol(int N, int[][] map){
        int answer = 0;
        Info cur = new Info(N/2, N/2);  // 시작위치 설정

        int cnt = 0;
        int size = 1;
        int dir = 0;
        while(true){
            if (cnt++ == 2){  // 이동 횟수는 1, 1, 2, 2, 3, 3, 4, 4 순으로 이동한다.
                cnt = 1;
                size += 1;
            }

            if (dir == 4){  // 방향 순서 조정
                dir = 0;
            }

            for (int i = 0; i < size; i++) {
                cur = move(cur, dir);
                if(isFinish(N, cur.r, cur.c)){
                    System.out.println(answer);
                    return;
                }
                answer += hurricane(N, map, dir, cur);
            }
            dir++;
        }
    }

    private static int hurricane(int N, int[][] map, int dir, Info cur) {
        int r = cur.r, c = cur.c;

        int total = 0;  // 이동한 모래 양
        int sum = 0;  // 나간 모래 양
        for (int i = 0; i < loc[dir].length-1; i++) {
            int nr = r + loc[dir][i][0];
            int nc = c + loc[dir][i][1];

            total += (int) (map[r][c] * percent[i]);  // 이동한 모래의 양 기록, 소수점 아래는 버려준다.
            if (isIn(N, nr, nc)){
                map[nr][nc] += (int) (map[r][c] * percent[i]);
            } else{
                sum += (int) (map[r][c] * percent[i]);
            }
        }

        int nr = r + loc[dir][loc[dir].length-1][0];
        int nc = c + loc[dir][loc[dir].length-1][1];
        if (isIn(N, nr, nc)){
            map[nr][nc] += map[r][c] - total;
        }else{
            sum += map[r][c] - total;
        }

        return sum;
    }

    private static Info move(Info cur, int dir){
        return new Info(cur.r + delta[dir][0], cur.c + delta[dir][1]);
    }

    private static boolean isIn(int N, int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    private static boolean isFinish(int N, int row, int col){
        return row < 0 || row >= N || col < 0 || col >= N;
    }

    private static class Info{  // 토네이도 현재 위치를 추적해주기 위해 생성한 class
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
