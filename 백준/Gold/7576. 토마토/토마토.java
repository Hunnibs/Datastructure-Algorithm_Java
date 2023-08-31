import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-31
 * - @see https://www.acmicpc.net/problem/7576
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 */
public class Main {
    static class Info{
        int row, col, day;

        public Info(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
    static int M, N;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                tomatoes[r][c] = Integer.parseInt(st.nextToken());

                if(tomatoes[r][c] == -1 || tomatoes[r][c] == 1){
                    visited[r][c] = true;
                }
            }
        }
        if(check(visited)){
            System.out.println(0);
        } else {
            int day = bfs(tomatoes, visited);
            if (check(visited)) {
                System.out.println(day);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static boolean check(boolean[][] visited){
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c] == false){
                    return false;
                }
            }
        }
        return true;
    }

    private static int bfs(int[][] tomatoes, boolean[][] visited){
        Queue<Info> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(tomatoes[r][c] == 1){
                    queue.offer(new Info(r,c,0));
                }
            }
        }

        int tr, tc;
        int day = 0;
        while(!queue.isEmpty()){
            Info current = queue.poll();
            for (int i = 0; i < 4; i++){
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];
                day = current.day;
                if(isIn(tr,tc) && !visited[tr][tc]){
                    Info next = new Info(tr, tc, current.day+1);
                    queue.offer(next);
                    visited[tr][tc] = true;
                }
            }
        }

        return day;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}