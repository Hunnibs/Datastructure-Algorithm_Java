package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-09-15
- @see https://www.acmicpc.net/problem/ BOJ_02342
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Dynamic Programming
- @note
 Z축에 들어오는 배열의 순서정보를 차례대로 기록
 X, Y축에 각각 왼쪽 발, 오른쪽 발 위치와 해당 배열에는 그 때 사용한 힘의 양을 저장해서 기록

 1. 같은 지점 밟으면 힘 1
 2. 중앙에서 사방으로 퍼질 때 힘 2
 3. 옆에서 바로 양 옆으로 이동할 때 힘 3
 4. 옆에서 반대 쪽으로 이동할 때 힘 4
 */

public class  BOJ_02342 {
    static int[][][] ddr = new int[100000][5][5];
    static int position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        position = 0;
        int idx = 0;
        st = new StringTokenizer(br.readLine());

        // init
        position = Integer.parseInt(st.nextToken());
        if (position == 0){
            System.out.println(0);
        } else {
            ddr[0][0][position] = 2;
            ddr[0][position][0] = 2;

            // main
            while (true) {
                position = Integer.parseInt(st.nextToken());

                if (position == 0) {  // 탈출 조건
                    break;
                }

                search(idx++);
            }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(Arrays.toString(ddr[i][j]));
            }
            System.out.println("----------");
        }
            System.out.println(findMin(idx));
        }
    }

    private static int findMin(int idx){
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (ddr[idx][r][c] == 0){
                    continue;
                }
                min = Math.min(min, ddr[idx][r][c]);

            }
        }

        return min;
    }

    private static void search(int idx){
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (ddr[idx][r][c] != 0){  // 이전 게임에 밟은 경우
                    // 0. 가운데 발판에서 발을 뗐을 때
                    if (r == 0) {
                        ddr[idx + 1][position][c] = ddr[idx][r][c] + 2;
                    }
                    // 1. 같은 발판을 다시 밟아야 하는 경우
                    else if (r == position){
                        ddr[idx+1][r][c] = ddr[idx][r][c] + 1;
                    }
                    // 2. 반대쪽 발판을 밟게 되는 경우
                    else if ((r + 2) % 5 == position) {// 왼발이 움직인 경우
                        ddr[idx + 1][position][c] = ddr[idx][r][c] + 4;
                    }
                    // 3. 나머지 경우
                    else{
                        ddr[idx+1][position][c] = ddr[idx][r][c] + 3;
                    }

                    // 0. 가운데 발판에서 발을 뗐을 때
                    if (c == 0) {
                        ddr[idx + 1][r][position] = ddr[idx][r][c] + 2;
                    }

                    // 1. 같은 발판을 다시 밟아야 하는 경우
                    else if (c == position){
                        ddr[idx+1][r][c] = ddr[idx][r][c] + 1;
                    }

                    // 2. 반대쪽 발판을 밟게 되는 경우
                    else if ((c + 2) % 5 == position) { // 오른발이 움직인 경우
                        ddr[idx + 1][r][position] = ddr[idx][r][c] + 4;
                    }

                    // 3. 나머지 경우
                    else{
                        ddr[idx+1][r][position] = ddr[idx][r][c] + 3;
                    }
                }
            }
        }
    }
}
