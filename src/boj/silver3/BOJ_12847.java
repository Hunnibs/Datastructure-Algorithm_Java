package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/12/2023
- @see https://www.acmicpc.net/problem/12847
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Sliding Window
- @note */

public class BOJ_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        // input end

        long sum = 0;
        long answer = 0;
        for (int i = 0; i < M; i++) {
            sum += money[i];
        }
        answer = sum;

        for (int i = M; i < N; i++) {
            sum = sum - money[i-M] + money[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
