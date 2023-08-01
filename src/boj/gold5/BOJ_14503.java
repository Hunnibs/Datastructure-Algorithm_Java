package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, row, col, d, answer;
    static int[][] room;
    static int[][] visited;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        visited = new int[N][M];

        // room 정보 입력
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
                if (room[r][c] == 1) { // 벽이라면 visited에 표시
                    visited[r][c] = 1;
                }
            }
        }


        while (true) {
            if (visited[row][col] == 0){
                answer++;
                visited[row][col] = 1;
            }

            Boolean check = turn();
            if (check) {
                while (true) {
                    if (--d < 0) {
                        d = 3;
                    }

                    if (go()) {
                        row += delta[d][0];
                        col += delta[d][1];
                        break;
                    }
                }
            } else{
                back();
                if (room[row][col] == 1 && visited[row][col] == 1){
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    // 회전 여부 탐색
    static Boolean turn(){
        int tr = 0, tc = 0;
        for (int i= 0; i< 4; i++){
            tr = row + delta[i][0];
            tc = col + delta[i][1];
            if (visited[tr][tc] == 0 && room[tr][tc] == 0){  // 방문하지 않았고 청소도 안되어있는게 있다면 회전해서 청소를 진행한다.
                return true;
            }
        }
        return false;
    }

    static Boolean go(){
        int tr = row + delta[d][0];
        int tc = col + delta[d][1];

        if (visited[tr][tc] == 1) {
            return false;
        } else{
            return true;
        }
    }

    static void back(){
        row += delta[d][0] * (-1);
        col += delta[d][1] * (-1);
    }


//    static Boolean isIn(int tr, int tc){
//        if (tr >= 0 && tr < row && tc >= 0 && tc < col){
//            return true;
//        } else{
//            return false;
//        }
//    }
}
