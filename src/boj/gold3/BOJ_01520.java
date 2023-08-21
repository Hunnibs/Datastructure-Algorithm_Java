package boj.gold3;

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
 시작 지점은 (0, 0) 고정, 끝나는 지점은 (M-1, N-1) 고정
 특정 위치에 도달했을 때 끝까지 방문이 가능했던 지점이라면 더 탐색할 필요도 없이 개수만 추가해준다.
 
 1. flag를 사용해서 visited 배열에 해당 칸이 끝까지 방문할 수 있는 경우라면 더 탐색할 필요도 없이 +1을 해주는 방식을 고려
 재귀문을 돌고 나오는 과정에서 flag값이 변하는 것을 모두 추적해줄 수가 없어서 포기
 
 2. 방문 배열을 돌고 나오는 길을 테이블을 이용해서 저장하는 방식
 특정 칸에 방문 했을 때 다음 칸이 이미 방문했으면 0이 아닌 값이 저장되어 있으므로 현재 칸에 그 값을 더해준다.
 */

public class BOJ_01520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N;
    static int[][] map, isAvailable;
    static boolean[][] visited;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];  // dfs 탐색 중 중복 여부 판단을 위해서 만들어준다. 
        isAvailable = new int[M][N];  // dp table과 동일하게 쓰일 예정
        map = new int[M][N];
        for (int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        dfs(0, 0);

        System.out.println(isAvailable[0][0]);
    }

    private static void dfs(int r, int c){
        if (r == M - 1 && c == N - 1) {  // 마지막 칸에 도달하면 증가
            isAvailable[r][c]++;
            return;
        }
 
        int tr, tc;
        for (int i = 0; i < 4; i++){
            tr = r + delta[i][0];
            tc = c + delta[i][1];

            if (isIn(tr, tc) && map[r][c] > map[tr][tc] && isAvailable[tr][tc] == 0 && !visited[tr][tc]) {  // 이동가능한 경로인데 아직 방문을 안 했을 경우
                dfs(tr, tc); 
                visited[tr][tc] = true;
                if (isAvailable[tr][tc] != 0){  // 탐색을 하고 나왔더니 값이 업데이트 되어있다는 것은 해당 경로의 끝이 목표지점과 연결이 되어있다는 뜻
                    isAvailable[r][c] += isAvailable[tr][tc];
                }
            }else if (isIn(tr, tc) && map[r][c] > map[tr][tc] && isAvailable[tr][tc] != 0){  // 방문을 했을 경우
                isAvailable[r][c] += isAvailable[tr][tc];
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < M && col >= 0 && col < N;
    }
}
