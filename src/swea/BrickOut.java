package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-10-05
 * - @see
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */

public class BrickOut {
    static class Info {
        int col, row, weight;

        public Info(int col, int row, int weight) {
            this.col = col;
            this.row = row;
            this.weight = weight;
        }
    }

    static int N, W, H, answer;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            int[][] map = new int[H][W];
            for (int c = 0; c < H; c++) {
                st = new StringTokenizer(br.readLine());
                for (int r = 0; r < W; r++) {
                    map[c][r] = Integer.parseInt(st.nextToken());
                }
            }

            int[] choosed = new int[N];
            permutation(0, choosed, map);
            sb.append("#" + test_case + " ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int result(int[][] map) {
        int sum = 0;
        for (int c = 0; c < H; c++) {
            for (int r = 0; r < W; r++) {
                if (map[c][r] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void update(int[][] map) {
        for (int r = 0; r < W; r++) {
            for (int c = H - 1; c >= 0; c--) {
                if (map[c][r] == 0) {
                    for (int t = c - 1; t >= 0; t--) {
                        if (map[t][r] != 0) {
                            map[c][r] = map[t][r];
                            map[t][r] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void chainBreak(int[][] map, int col, int row) {
        int nc, nr, rep;
        rep = map[col][row] - 1;
        map[col][row] = 0;
        if (rep == 0){  // 더 부술게 없는 경우
            return;
        }
        for (int i = 0; i < 4; i++) {
            nc = col;
            nr = row;
            for (int j = 0; j < rep; j++) {
                nc = nc + delta[i][0];
                nr = nr + delta[i][1];
                if (isIn(nc, nr) && map[nc][nr] != 0) {
                    chainBreak(map, nc, nr);
                }
            }
        }
    }

    private static boolean shoot(int[][] map, int row) {
        int idx = 0;  // 공을 쐈을 때 가장 처음 맞는 벽돌
        while (map[idx][row] == 0) {
            if (++idx == H) {
                return false;
            }
        }
        chainBreak(map, idx, row);
        return true;
    }

    private static void permutation(int depth, int[] choosed, int[][] map) {
        if (depth == N) {
            int[][] virtualMap = new int[H][W];
            for (int c = 0; c < H; c++) {
                virtualMap[c] = map[c].clone();
            }
            for (int i = 0; i < N; i++) {
                if (shoot(virtualMap, choosed[i])){
                    update(virtualMap);
                }
            }
            answer = Math.min(answer, result(virtualMap));
            return;
        } else {
            for (int i = 0; i < W; i++) {
                choosed[depth] = i;
                permutation(depth + 1, choosed, map);
            }
        }
    }

    private static boolean isIn(int col, int row) {
        return col >= 0 && col < H && row >= 0 && row < W;
    }
}