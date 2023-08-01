package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sudoku {
    static int T;
    static int[][] arr;

    public static boolean row(int x) {
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 0);
        for (int i = 0; i < 9; i++) {
            if (arr2[arr[i][x]] == 0) {
                arr2[arr[i][x]] = 1;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean col(int x) {
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 0);
        for (int i = 0; i < 9; i++) {
            if (arr2[arr[x][i]] == 0) {
                arr2[arr[x][i]] = 1;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean box(int x, int y) {
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 0);
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                if (arr2[arr[i][j]] == 0) {
                    arr2[arr[i][j]] = 1;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String arg[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 1;

            for (int i = 0; i < 9; i++) {
                if (row(i) == false) {
                    answer = 0;
                    break;
                }

                if (col(i) == false) {
                    answer = 0;
                    break;
                }
            }

            if(answer != 0) {
                for (int i = 0; i < 9; i+=3) {
                    for(int j = 0; j < 9; j+=3) {
                        if (box(i, j) == false) {
                            answer = 0;
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + Integer.toString(test_case) + " " + Integer.toString(answer));
        }
    }
}
