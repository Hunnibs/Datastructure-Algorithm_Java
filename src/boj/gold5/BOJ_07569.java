package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Info{
    int x;
    int y;
    int z;
    int day;

    public Info(int z, int x, int y, int day) {
        this.day = day;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BOJ_07569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static Deque<Info> dq = new ArrayDeque<>();
    static int[][] delta = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}};
    static int[][][] tomatoes;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    tomatoes[d][r][c] = Integer.parseInt(st.nextToken());
                    if (tomatoes[d][r][c] == 1) {
                        dq.offer(new Info(d, r, c, 0));
                    }
                }
            }
        }

        int answer = bfs();
        outer: for (int d = 0; d < H; d++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (tomatoes[d][r][c] == 0) {
                        answer = -1;
                        break outer;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(){
        int row, col, dim, day = 0;
        int tr, tc, td;
        while(!dq.isEmpty()){
            dim = dq.peekFirst().z;
            row = dq.peekFirst().x;
            col = dq.peekFirst().y;
            day = dq.pollFirst().day;
            for (int i = 0; i < 6; i++) {
                td = dim + delta[i][0];
                tr = row + delta[i][1];
                tc = col + delta[i][2];
                if(isIn(td, tr, tc)){
                    if (tomatoes[td][tr][tc] == 0) {
                        tomatoes[td][tr][tc] = 1;
                        dq.offer(new Info(td, tr, tc, day+1));
                    }
                }
            }
        }
        return day;
    }

    private static boolean isIn(int dim, int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M && dim >= 0 && dim < H;
    }
}
