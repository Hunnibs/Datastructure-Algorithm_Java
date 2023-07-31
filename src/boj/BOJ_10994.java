package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int tmp = N;
        int r = 0, c = 0;
        String[][] arr = new String[4 * N - 3][4 * N - 3];
        for (int i = 0; i < 4 * N - 3; i++){
            Arrays.fill(arr[i], " ");
        }

        for (int t = N; t >= 0; t--){
            for (int i = r; i < (r + 4 * N - 3); i++){
                for(int j = c; j < (c + 4 * N - 3); j++){
                    if(i == r || i == (r + 4 * N - 4) || j == c || j == (r + 4 * N - 4)){
                        arr[i][j] = "*";
                    }
                }
            }
            r += 2;
            c += 2;
            N--;
        }

        for (int i = 0; i < 4 * tmp - 3; i ++){
            for (int j = 0; j < 4 * tmp -3; j++){
                if (arr[i][j].equals("*")){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
