package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static class Info{
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, T;
    static int[][] room;
    static int[][] cleaners = new int[2][2];
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        int i = 0;
        for (int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++){
                room[r][c] = Integer.parseInt(st.nextToken());

                if (room[r][c] == -1){
                    cleaners[i][0] = r;
                    cleaners[i][1] = c;
                    i++;
                }
            }
        }

        // main
        for (int time = 0; time < T; time++) {
            spread();
            airCleaner1();
            airCleaner2();
        }

        System.out.println(check());
    }

    private static int check(){
        int answer = 0;
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (room[r][c] != -1){
                    answer += room[r][c];
                }
            }
        }

        return answer;
    }

    private static void airCleaner1(){
        Stack<Info> stack = new Stack<>();
        stack.add(new Info(cleaners[0][0], cleaners[0][1]));

        int tr, tc;
        int d = 0;
        while (!stack.isEmpty()){
            Info info = stack.pop();

            tr = info.r + delta[d][0];
            tc = info.c + delta[d][1];
            if (tr == cleaners[0][0] && tc == cleaners[0][1]){
                room[info.r][info.c] = 0;
                return;
            }

            if (isIn(tr, tc) && tr <= cleaners[0][0]){
                if (room[info.r][info.c] != -1) {
                    room[info.r][info.c] = room[tr][tc];
                }
                stack.add(new Info(tr, tc));
            } else{
                stack.add(info);
                if (++d == 4){
                    d %= 4;
                }
            }
        }
    }

    private static void airCleaner2(){
        Stack<Info> stack = new Stack<>();
        stack.add(new Info(cleaners[1][0], cleaners[1][1]));

        int tr, tc;
        int d = 2;
        while (!stack.isEmpty()){
            Info info = stack.pop();

            tr = info.r + delta[d][0];
            tc = info.c + delta[d][1];
            if (tr == cleaners[1][0] && tc == cleaners[1][1]){
                room[info.r][info.c] = 0;
                return;
            }

            if (isIn(tr, tc) && tr >= cleaners[1][0]){
                if (room[info.r][info.c] != -1) {
                    room[info.r][info.c] = room[tr][tc];
                }
                stack.add(new Info(tr, tc));
            } else{
                stack.add(info);
                if (--d < 0){
                    d = 3;
                }
            }
        }
    }

    private static void spread(){  // 전체 칸에 대해 먼지를 확산 시키기
        int[][] spreadRoom = new int[R][C];

        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (room[r][c] == -1){  // 공기청정기 위치 복사
                    spreadRoom[r][c] = -1;
                } else {
                    spreadDust(r, c, spreadRoom);
                }
            }
        }

        updateRoom(spreadRoom);
    }

    private static void updateRoom(int[][] spreadRoom){
        for (int r = 0; r < R; r++){
            room[r] = spreadRoom[r].clone();
        }
    }

    private static void spreadDust(int row, int col, int[][] spreadRoom){  // 칸 당 먼지가 확산되는 것을 담당
        int tr, tc;
        int cnt = 0;
        for (int i = 0; i < 4; i++){
            tr = row + delta[i][0];
            tc = col + delta[i][1];
            if (isIn(tr, tc) && room[tr][tc] != -1){
                spreadRoom[tr][tc] += room[row][col] / 5;
                cnt++;
            }
        }
        spreadRoom[row][col] += (room[row][col] - room[row][col] / 5 * cnt);
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    private static void print(){
        for (int r = 0; r < R; r++){
            System.out.println(Arrays.toString(room[r]));
        }
    }
}

