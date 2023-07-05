package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FliesExterminator {
    static int T;
    static int N;
    static int M;
    static int[][] arr;

    public int plus(int x, int y) {
        int sum = arr[x][y];
        for (int i = x-M; i <= x+M; i++) {
            if (i == x){
                continue;
            }else if (i >= 0 && i < N){
                sum += arr[i][y];
            }
        }

        for (int i = y-M; i <= y+M; i++) {
            if (i == y){
                continue;
            }else if (i >= 0 && i < N){
                sum += arr[x][i];
            }
        }
        return sum;
    }

    public int multi(int x, int y) {
        int sum = arr[x][y];
        for (int i = -M; i <= M; i++) {
            if (i == 0){
                continue;
            }else if (x+i >= 0 && x+i < N && y-i >= 0 && y-i < N){
                sum += arr[x+i][y-i];
            }
        }

        for (int i = -M; i <= M; i++) {
            if (i == 0){
                continue;
            }else if (x+i >= 0 && x+i < N && y+i >= 0 && y+i < N){
                sum += arr[x+i][y+i];
            }
        }
        return sum;
    }

    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        FliesExterminator s = new FliesExterminator();

        T = Integer.parseInt(st.nextToken());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken())-1;
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(s.plus(i, j), max);
                    max = Math.max(s.multi(i, j), max);
                }
            }

            System.out.println("#" + Integer.toString(test_case) + " " + Integer.toString(max));
        }
    }
}
