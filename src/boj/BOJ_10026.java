package boj;

/**

@author 이병헌
@since 2023. 08. 21
@see https://www.acmicpc.net/problem/10026
@git
@youtube
@performance
@category # BFS
@note
 두 개의 배열을 만든다. 하나는 정상인이 보는 배열, 하나는 적록색약이 보는 배열
 배열을 전체를 돌면서 같은 색깔인 것들을 묶어서 탐색해주고 방문처리를 해주면서 총 몇 번의 탐색을 하게 되는지 세어준다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_10026 {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Queue<Info> queue = new ArrayDeque<>();
    static int N;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        char[][] normal = new char[N][N];
        char[][] abnormal = new char[N][N];
        for (int r = 0; r < N; r++){
            String S = br.readLine();
            for (int c = 0; c < N; c++){
                normal[r][c] = S.charAt(c);
                if(normal[r][c] == 'G'){
                    abnormal[r][c] = 'R';
                } else{
                    abnormal[r][c] = S.charAt(c);
                }
            }
        }

        boolean[][] visitedN = new boolean[N][N];
        boolean[][] visitedA = new boolean[N][N];
        int cntN = 0, cntA = 0;
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                if (!visitedN[r][c]){
                    bfs(visitedN, normal, r, c);
                    cntN++;
                }
                if (!visitedA[r][c]){
                    bfs(visitedA, abnormal, r, c);
                    cntA++;
                }
            }
        }

        System.out.println(cntN + " " + cntA);
    }

    private static void bfs(boolean[][] visited, char[][] array, int r, int c){
        char color = array[r][c];
        visited[r][c] = true;
        queue.offer(new Info(r, c));
        Info info;
        int tr, tc;
        while(!queue.isEmpty()){
            info = queue.poll();
            for (int i = 0; i < 4; i++){
                tr = info.row + delta[i][0];
                tc = info.col + delta[i][1];
                if (isIn(tr, tc) && !visited[tr][tc] && array[tr][tc] == color){
                    visited[tr][tc] = true;
                    queue.offer(new Info(tr, tc));
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
