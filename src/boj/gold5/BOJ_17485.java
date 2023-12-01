package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 11/26/23
 * - @see https://www.acmicpc.net/problem/17485
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * N * M 행렬 아래로만 움직일 수 있으며 좌대각, 아래, 우대각이 가능 -> 단, 한 번 움직인 방향으로는 움직일 수 없다.
 * DFS 알고리즘을 통해 해결할 예정
 * depth 이동 시 필요 parameter => 현재 위치 관련, 방향 정보,
 */

public class BOJ_17485 {
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

        // main dp logic
        int[][][] dp = new int[N][M][3];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (r == 0) {
                    for (int i = 0; i < 3; i++) {
                        dp[r][c][i] = map[r][c];  // 맨 첫 칸은 모두 초기화 시켜준다.
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        dp[r][c][i] = Integer.MAX_VALUE;  // 맨 첫 칸은 모두 초기화 시켜준다.
                    }
                }
            }
        }

        // 움직일 때 다른 방향에서 들어온 값만 업데이트 해준다.
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 3; i++) {
                    int nr = r - delta[i][0];
                    int nc = c - delta[i][1];
                    if (isIn(nr, nc)) {
                        if (i == 0) {
                            dp[r][c][i] = map[r][c] + Math.min(dp[nr][nc][1], dp[nr][nc][2]);
                        } else if (i == 1) {
                            dp[r][c][i] = map[r][c] + Math.min(dp[nr][nc][0], dp[nr][nc][2]);
                        } else {
                            dp[r][c][i] = map[r][c] + Math.min(dp[nr][nc][0], dp[nr][nc][1]);
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int c = 0; c < M; c++) {
            for (int i = 0; i < 3; i++) {
                answer = Math.min(answer, dp[N - 1][c][i]);
            }
        }

        System.out.println(answer);
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}