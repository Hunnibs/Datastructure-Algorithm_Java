package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 9/17/2023
- @see https://www.acmicpc.net/problem/11047
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Dynamic Programming
- @note */

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // main
        int answer = 0;
        for (int i = N-1; i >= 0 ; i--) {
            if (K % coins[i] >= 0 && coins[i] * (K / coins[i]) >= 0){
                answer += K / coins[i];
                K -= coins[i] * (K / coins[i]);
            }

            if (K == 0){
                break;
            }
        }

        System.out.println(answer);
    }
}