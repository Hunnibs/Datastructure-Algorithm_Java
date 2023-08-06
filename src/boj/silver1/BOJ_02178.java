package boj.silver1;

/**

 @author 이병헌
 @since 2023. 8. 6.
 @see https://www.acmicpc.net/problem/2178
 @git
 @youtube
 @performance
 @category # BFS
 @note
 (0,0)부터 (N-1, M-1)까지 가는 가장 최단경로 구하기

 # BFS 탐색 시 마지막에 최단경로가 저장될 수 밖에 없는 이유는 visited 배열을 사용해 먼저 방문한 경로가 있을 경우에는 업데이트가 되지 못하게 막기 때문이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_02178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, row, col, tr, tc;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] answer;
    static char[][] maze;
    static boolean[][] visited;
    static ArrayList<Integer> tmp;
    static Deque<ArrayList<Integer>> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        String S;
        for (int r = 0; r < N; r++) {
            S = br.readLine();
            maze[r] = S.toCharArray();
        }

        //
        answer[0][0] = 1;
        visited[0][0] = true;
        tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(0);
        dq.offer(tmp);
        bfs();

        System.out.println(answer[N-1][M-1]);
    }

    private static void bfs(){
        while(!dq.isEmpty()) {
            row = dq.peekFirst().get(0);
            col = dq.pollFirst().get(1);
            for (int i = 0; i < 4; i++) {
                tr = row + delta[i][0];
                tc = col + delta[i][1];
                if (isIn() && !visited[tr][tc] && maze[tr][tc] == '1') {
                    visited[tr][tc] = true;
                    answer[tr][tc] = answer[row][col]+1;
                    tmp = new ArrayList<>();
                    tmp.add(tr);
                    tmp.add(tc);
                    dq.add(tmp);
                }
            }
        }
    }

    private static boolean isIn(){
        if (tr >= 0 && tr < N && tc >= 0 && tc < M) {
            return true;
        } else{
            return false;
        }
    }
}
