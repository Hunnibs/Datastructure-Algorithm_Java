import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 10/16/23
- @see https://www.acmicpc.net/problem/2240
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class Main {
    static int T, W, max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T+1][W+1];
        for (int i = 1; i <= T ; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            for (int j = 0; j <= W; j++) {
                if (j % 2 == num){
                    dp[i][j] = dp[i-1][j] + 1;
                } else{
                    if (j == 0){
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[T][W]);
    }
}