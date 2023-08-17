package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long answer = 0;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mod = new int[M];
        int[] nums = new int[N+1];
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = (dp[i-1] + nums[i]) % M;
            mod[dp[i]]++;
        }

        answer += mod[0];
        for (int i = 0; i < M; i++) {
            answer += (((long)(mod[i]-1) * (long)mod[i]) / 2);
        }

        System.out.println(answer);
    }
}
