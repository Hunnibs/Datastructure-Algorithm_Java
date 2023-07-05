package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateArray {
    static int[][] array;
    static int T;
    static int N;

    public int[][] Rotate(int[][] array){
        int[][] array2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                array2[i][j] = array[j][N-i-1];
            }
        }
        return array2;
    }

    public static void main(String args[]) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        RotateArray s = new RotateArray();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            array = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int [][] array_90 = s.Rotate(array);
            int [][] array_180 = s.Rotate(array_90);
            int [][] array_270 = s.Rotate(array_180);

            System.out.println("#" + Integer.toString(test_case));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(array_270[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(array_180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(array_90[i][j]);
                }
                System.out.println(" ");
            }
        }
    }
}
