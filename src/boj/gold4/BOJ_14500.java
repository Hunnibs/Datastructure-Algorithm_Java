package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2024-02-28
 * - @see https://www.acmicpc.net/problem/14500
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2sec 512MB
 * - @category # DFS
 * - @note
 */

public class BOJ_14500 {
    private static final boolean[][][] tetromino =
            {
                    {{true, true, true, true}},
                    {{true, true}, {true, true}},
                    {{true}, {true}, {true, true}},
                    {{true}, {true, true}, {false, true}},
                    {{true, true, true}, {false, true}},
                    {{true}, {true}, {true}, {true}},
                    {{true, true, true}, {true}},
                    {{false, true, true}, {true, true}},
                    {{false, true}, {true, true}, {false, true}},
                    {{true, true}, {false, true}, {false, true}},
                    {{false, true, false}, {true, true, true,}},
                    {{false, false, true}, {true, true, true,}},
                    {{true}, {true, true}, {true}},
                    {{false, true}, {false, true}, {true, true}},
                    {{true}, {true, true, true}},
                    {{true, true}, {true}, {true}},
                    {{true, true, true}, {false, false, true}},
                    {{false, true}, {true, true}, {true}},
                    {{true, true}, {false, true, true}}
            };
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
        //input end
        System.out.print(sol(map));
    }

    private static int sol(int[][] map){
        int answer = 0;

        for (int i = 0; i < tetromino.length; i++) {
            boolean[][] block = tetromino[i];
            answer = Math.max(answer, blockCheck(map, block));
        }

        return answer;
    }

    private static int blockCheck(int[][] map, boolean[][] block){
        int size = 0;

        for (int r = 0; r <= N - block.length; r++) {
            for (int c = 0; c < M; c++) {
                size = Math.max(size, sizeCheck(map, r, c, block));
            }
        }

        return size;
    }

    private static int sizeCheck(int[][] map, int r, int c, boolean[][] block){
        int sum = 0;

        for (int nr = 0; nr < block.length; nr++) {
            for (int nc = 0; nc < block[nr].length; nc++) {
                if (c + nc >= M){
                    return 0;
                }

                if (block[nr][nc]){
                    sum += map[r + nr][c + nc];
                }
            }
        }

        return sum;
    }

    private static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
