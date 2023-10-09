package boj.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023/10/08
 * - @see https://www.acmicpc.net/problem/17136
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * 쉬운 탐색 문제라고 생각했다가 greedy 방식이 통하지 않는다는 사실에 다시 메모리를 보고 512MB를 보며 가지가 많이 나온다는 걸 예측한 문제
 * 512MB는 함정이라 생각했는데 써야 풀 수 있는 문제..
 */

public class BOJ_17136 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] remainCnt = {0, 5, 5, 5, 5, 5};
        int[][] paper = new int[10][10];
        for (int r = 0; r < 10; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //main
        search(paper, remainCnt);
        if (answer == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    private static int answerCheck(int[] remain){
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            sum += (5-remain[i]);
        }

        return sum;
    }

    private static void update(int[][] paper, int[] remain, int row, int col, int size) {  // 말그대로 update 해주는거
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                paper[r][c] = 0;
            }
        }
        remain[size]--;
    }

    private static boolean check(int[][] paper, int row, int col, int size) {  // 붙일 수 있는지 판단
        if (!isIn(row + size - 1, col + size - 1)) {
            return false;
        }
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (paper[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void search(int[][] paper, int[] remain) {  // 돌다가  붙일 수 있는 곳 만나면 size 별로 전부 붙여봄
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (paper[r][c] == 1){
                    for (int size = 5; size > 0; size--) {
                        if (check(paper, r, c, size)){
                            if(remain[size] - 1 >= 0) {
                                int[][] newPaper = clone(paper);
                                int[] newRemain = remain.clone();
                                update(newPaper, newRemain, r, c, size);
                                search(newPaper, newRemain);
                            } else{
                                if (size == 1){
                                    return;
                                } else{
                                    continue;
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
        answer = Math.min(answer, answerCheck(remain));
    }

    private static int[][] clone(int[][] paper){  // 그저 복사 기능 원툴
        int[][] clone = new int[10][];
        for (int r = 0; r < 10; r++) {
            clone[r] = paper[r].clone();
        }

        return clone;
    }

    private static boolean isIn(int row, int col) {  // 안에 있나 없나 판별
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
}
