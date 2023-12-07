    package boj.gold5;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    /**

    - @author 이병헌
    - @since 12/7/23
    - @see https://www.acmicpc.net/problem/1241
    - @git https://github.com/Hunnibs
    - @youtube
    - @performance 2sec, 128MB
    - @category # Dynamic Programming # Memorization
    - @note
     배수를 +1씩 업데이트해준다.
     */

    public class BOJ_01241 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());

            int[] list = new int[N];

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                list[i] = num;
            }

            int[] dp = new int[1_000_001];
            for (int i = 0; i < N; i++) {
                dp[list[i]]++;
            }

            int[] ans = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 1; j * j <= list[i]; j++) {
                    if (list[i] % j == 0) {
                        if (list[i] / j == j){
                            ans[i] += dp[j];
                        } else{
                            ans[i] += dp[j] + dp[list[i]/ j];
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println(ans[i]-1);
            }
        }
    }
