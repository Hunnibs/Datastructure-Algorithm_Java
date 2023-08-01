package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_03190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, L, row, col, d, idx, cnt;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] board;
    static String[][] dir;
    static Deque<ArrayList<Integer>> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // board init
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        // 사과 위치 표시
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            board[row-1][col-1] = 2;
        }

        // 방향 전환 타이밍 입력
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        dir = new String[L][2];
        for (int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            dir[i][0] = st.nextToken();
            dir[i][1] = st.nextToken();
        }

        // main Logic
        row = 0;
        col = 0;
        d = 1;
        idx = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(row);
        tmp.add(col);
        dq.add(tmp);
        while(true){

            cnt++;
            row += delta[d][0];
            col += delta[d][1];
            // 꼬리와 머리가 부딪히면 game over
            if (!dq.isEmpty()) {
                int flag = 0;
                int n = dq.size();
                for (int i = 0; i < n; i++) {
                    if (dq.getFirst().get(0) == row && dq.getFirst().get(1) == col) {
                        flag = 1;
                    }
                    dq.add(dq.pollFirst());
                }
                if (flag == 1){
                    break;
                }
            }

            // 벽에 부딪혀도 game over
            if(notIsIn()){
                break;
            }

            tmp = new ArrayList<>();
            tmp.add(row);
            tmp.add(col);
            dq.add(tmp);

            // 사과가 없다
            if (board[row][col] != 2){
                dq.removeFirst();
            } else if (board[row][col] == 2){
                board[row][col] = 0;
            }

            if (idx < L) {
                if (dir[idx][0].equals(Integer.toString(cnt))) {
                    turn(dir[idx++][1]);
                }
            }
        }
        System.out.println(cnt);
    }

    static void turn(String dir){
        if (dir.equals("D")) { // 으론쪽 회전
            if (++d > 3){
                d = 0;
            }
        } else{
            if (--d < 0){ // 왼쪽 회전
                d = 3;
            }
        }
    }

    static Boolean notIsIn(){
        if (row >= 0 && row < N && col >= 0 && col < N){
            return false;
        }
        return true;
    }
}
