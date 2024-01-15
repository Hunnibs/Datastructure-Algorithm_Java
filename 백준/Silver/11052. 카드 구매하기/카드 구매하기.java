import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/15/24
- @see https://www.acmicpc.net/problem/11052
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 256MB
- @category # Dynamic Programming
- @note
 2차원 dp 테이블을 만들어서 패딩 필요
 dp[r][c] = Max(dp[r-1][c-i] + p[i], dp[r-1][c])
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // input end
        sol(N, P);
    }

    private static void sol(int n, int[] p) {
        int[] maxPay = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                maxPay[i] = Math.max(maxPay[i], maxPay[i-j] + p[j]);
            }
        }

        System.out.println(maxPay[n]);
    }

//    private static void sol(int n, int[] p) {
//        int[][] dp = new int[n+1][n+1];
//
//        for (int r = 1; r <= n; r++) {
//            for (int c = 1; c < r; c++) {
//                dp[r][c] = Math.max(dp[r][c], dp[r - 1][c]);
//            }
//
//            for (int c = r; c <= n; c++) {
//                dp[r][c] = Math.max(dp[r-1][c-r] + p[r], dp[r-1][c]);
//                dp[r][c] = Math.max(dp[r][c], dp[r][c-r] + p[r]);
//            }
//        }
//
//        System.out.println(dp[n][n]);
//    }
}