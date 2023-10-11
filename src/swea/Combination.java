package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since
- @see
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class Combination {
    static final long MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int answer = (int) (((factorial(n) % MOD) * (pow((factorial(r) * factorial(n-r)) % MOD, MOD-2) % MOD)) % MOD);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
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

    private static long factorial(int num){
        long answer = 1;
        while(num > 1){
            answer = (answer * (num--)) % MOD;
        }
        return answer;
    }
}
