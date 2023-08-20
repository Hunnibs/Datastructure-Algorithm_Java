package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 08. 20
@see  https://www.acmicpc.net/problem/1520
@git
@youtube
@performance
@category # DFS
@note
 시작 지점은 (0, 0) 고정, 끝나는 지점은 (M-1, N-1) 고정
 특정 위치에 도달했을 때 끝까지 방문이 가능했던 지점이라면 더 탐색할 필요도 없이 개수만 추가해준다.
 */

public class BOJ_01520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, H;
    static int[][] map, isAvailable;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        isAvailable = new int[M][N];
        map = new int[M][N];
        for (int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        dfs(0, 0);

//        for (int r = 0; r < M; r++){
//            System.out.println(Arrays.toString(isAvailable[r]));
//        }

        System.out.println(isAvailable[0][1] + isAvailable[1][0]);
    }

    private static void dfs(int r, int c){
        if (r == M - 1 && c == N - 1) {  // 도달하면 증가
            isAvailable[r][c]++;
            return;
        }

        int tr, tc;

        for (int i = 0; i < 4; i++){
            tr = r + delta[i][0];
            tc = c + delta[i][1];

            if (isIn(tr, tc) && map[r][c] > map[tr][tc] && isAvailable[tr][tc] == 0) {
                dfs(tr, tc);
                if (isAvailable[tr][tc] != 0){
                    isAvailable[r][c] = Math.max(isAvailable[r][c], isAvailable[tr][tc]);
                }
            }else if (isIn(tr, tc) && map[r][c] > map[tr][tc] && isAvailable[tr][tc] != 0){
                isAvailable[r][c] += isAvailable[tr][tc];
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < M && col >= 0 && col < N;
    }
}
