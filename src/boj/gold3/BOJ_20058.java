package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 1/27/24
 * - @see https://www.acmicpc.net/problem/20058
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # Implemetation
 * - @note
 * 얼음은 한날한시에 다같이 줄어야한다.
 *
 * 아 누구라도 이 글을 본다면 웹툰 그만보고 책 읽으세요
 * 그림보고 섣불리 판단한 저는 그러려합니다.
 */

public class BOJ_20058 {
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, Q, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2, N);
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        // input end

        sol(map, L);
    }

    private static void sol(int[][] map, int[] L) {
        for (int i = 0; i < Q; i++) {
            setRange(map, L[i]);
            melt(map);
        }

        totalIce(map);
    }

    // 격자 범위 정하는 함수
    private static void setRange(int[][] map, int L) {
        int[][] tmpMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmpMap[i] = map[i].clone();
        }

        int range = (int) Math.pow(2, L);
        int cnt = 0;

        for (int r = 0; r < n; r += range) {
            // 난 바둑판 처럼 돌렸지 격자 무늬로 다 나눠서
//            if (cnt % 2 == 0) {
//                for (int c = 0; c < n - range; c += (2 * range)) {
//                    turnGrid(map, r, c, range);
//                }
//            } else {
//                for (int c = range; c < n; c += (2 * range)) {
//                    turnGrid(map, r, c, range);
//                }
//            }
            for (int c = 0; c < n; c += range) {
                turnGrid(map, tmpMap, r, c, range);
            }
            cnt++;
        }

        for (int i = 0; i < n; i++) {
            map[i] = tmpMap[i].clone();
        }
    }

    // 격자 별 돌리기
    private static void turnGrid(int[][] map, int[][] tmpMap, int r, int c, int range) {
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                tmpMap[r + i][c + range - 1 - j] = map[r + j][c + i];
            }
        }
    }

    // 녹는 얼음 추적
    private static void melt(int[][] map) {
        int[][] tmpMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmpMap[i] = map[i].clone();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] > 0) {
                    if (isMelt(map, r, c) < 3){
                        tmpMap[r][c]--;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            map[i] = tmpMap[i].clone();
        }
    }

    private static int isMelt(int[][] map, int r, int c) {
        int cnt = 0;
        for (int[] d : delta) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (isIn(nr, nc) && map[nr][nc] > 0) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void totalIce(int[][] map) {
        boolean[][] visited = new boolean[n][n];
        int total = 0;
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] > 0) {
                    int size = dfs(map, visited, r, c);
                    max = Math.max(max, size);
                }
                total += map[r][c];
            }
        }

        System.out.println(total);
        System.out.println(max);
    }

    private static int dfs(int[][] map, boolean[][] visited, int r, int c) {
        Deque<Info> stack = new ArrayDeque<>();
        stack.offerLast(new Info(r, c));
        visited[r][c] = true;
        int size = 1;

        while (!stack.isEmpty()) {
            Info cur = stack.pollLast();

            for (int[] d : delta) {
                int nr = cur.row + d[0];
                int nc = cur.col + d[1];

                if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    stack.offerLast(new Info(nr, nc));
                    size++;
                }
            }
        }

        return size;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
