package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 1/2/24
 * - @see https://www.acmicpc.net/problem/20044
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 0.5sec 512MB - N <= 5000 & W(Si) <= 100_000
 * - @category # Greedy
 * - @note
 * sorting 이 후 비교해 나가면서 최솟값 구하
 */

public class BOJ_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] W = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        // input end
        Arrays.sort(W);
        System.out.println(sol(N, W));
    }

    private static int sol(int N, int[] W){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, W[i] + W[2 * N - 1 - i]);
        }

        return min;
    }
}
