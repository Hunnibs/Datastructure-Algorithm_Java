package boj.platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13977 {
    static final long MOD = 1_000_000_007;
    static long[] factorial = new long[4_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        factorial(1);

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int answer = (int) (((factorial[n] % MOD) * (pow((factorial[r] * factorial[n-r]) % MOD, MOD-2) % MOD)) % MOD);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static long pow(long a, long p){
        if(p == 1){
            return a % MOD;
        }
        long tmp = pow(a, p / 2);

        if (p % 2 == 1){
            return (((tmp * tmp) % MOD) * a) % MOD;
        }
        return (tmp * tmp) % MOD;
    }

    private static void factorial(int num){
        long answer = 1;
        while(num <= 4_000_000){
            answer = (answer * (num)) % MOD;
            factorial[num++] = answer;
        }
    }
}
