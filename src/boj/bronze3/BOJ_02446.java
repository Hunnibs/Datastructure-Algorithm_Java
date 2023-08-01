package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02446 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < 2 * N - 1; i++) {
            if (i > N - 1) {
                cnt += 2;
            }
            int tmp = i - cnt;
            for (int j = 0; j < 2 * N - 1; j++) {
                if (j < tmp) {
                    System.out.print(" ");
                } else if ((2 * N - 2 - j) < tmp) {
                    break;
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
