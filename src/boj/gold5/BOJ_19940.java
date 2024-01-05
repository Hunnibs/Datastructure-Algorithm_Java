package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2024-01-05
 * - @see https://www.acmicpc.net/problem/19940
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 0.25sec 256MB
 * - @category # Greedy # BFS
 * - @note
 */

public class BOJ_19940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[5];
            sol(N, arr);

            for (int j = 0; j < 5; j++) {
                sb.append(arr[j]).append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void sol(int N, int[] arr) {
        arr[0] += N / 60;
        N = N % 60;

        if (N <= 35) {
            if (N % 10 > 5) {
                arr[1] += N / 10 + 1;
                arr[4] += 10 - N % 10;
            } else {
                arr[1] += N / 10;
                arr[3] += N % 10;
            }
        } else {
            arr[0]++;
            if (N % 10 >= 5) {
                arr[2] += 6 - (N / 10 + 1);
                arr[4] += 10 - N % 10;
            } else {
                arr[2] += 6 - N / 10;
                arr[3] += N % 10;
            }
        }
    }

}