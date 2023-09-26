package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-09-26
 * - @see https://www.acmicpc.net/problem/2239
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Brute Force # BackTracking
 * - @note
 */

public class BOJ_02239 {
    static class Info {
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Info> blank = new ArrayList<>();
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = s.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    blank.add(new Info(i, j));
                }
            }
        }

        solve(sudoku, blank, 0);
    }

    private static void solve(int[][] sudoku, List<Info> blank, int idx) {
        if (idx == blank.size()) {
            flag = true;
            print(sudoku);
            return;
        } else {
            int row = blank.get(idx).row;
            int col = blank.get(idx).col;
            for (int i = 1; i <= 9; i++) {
                if (checkRow(sudoku, row, i) && checkCol(sudoku, col, i) && checkTable(sudoku, row, col, i)) {
                    sudoku[row][col] = i;
                    solve(sudoku, blank, idx + 1);
                    if (flag) {
                        return;
                    }
                    sudoku[row][col] = 0;
                }
            }
            if (sudoku[row][col] == 0) {
                return;
            }
        }
    }

    private static boolean checkTable(int[][] sudoku, int row, int col, int target) {
        int r, c;
        if (row == 0) {
            r = 0;
        } else {
            r = (row / 3) * 3;
        }

        if (col == 0) {
            c = 0;
        } else {
            c = (col / 3) * 3;
        }

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(int[][] sudoku, int row, int target) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == target) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int[][] sudoku, int col, int target) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == target) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
