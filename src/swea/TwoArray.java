package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoArray {
    static int T;
    static int N;
    static int M;
    static int[] A;
    static int[] B;

    public String Solution(int[] A, int[] B, int N, int M) {
        int max = 0;
        if (N > M) {
            for (int i = 0; i < N-M+1; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += B[j] * A[i + j];
                }
                if (sum > max){
                    max = sum;
                }
            }
        } else {
            for (int i = 0; i < M-N+1; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += A[j] * B[i + j];
                }
                if (sum > max){
                    max = sum;
                }
            }
        }
        return Integer.toString(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        TwoArray ta = new TwoArray();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + Integer.toString(i + 1) + " " + ta.Solution(A, B, N, M));
        }
    }
}
