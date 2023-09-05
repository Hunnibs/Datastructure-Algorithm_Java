import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 9/4/2023
- @see https://www.acmicpc.net/problem/12738
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Dynamic Programming # Memorization
- @note
 뒤에서부터 해당 숫자를 고른다고 생각을 한다.
 다음 앞에 있는 것부터 해당 숫자까지가 증가한다면 테이블에 +1을 해준다.

 점화식
 dp[i] = 1  -> 일단 초기화 하나는 고를 수 있으므로
 dp[i] = Math.max(dp[i], dp[j]+1)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = N-2; i >= 0; i--) {
            for (int j = i+1; j < N; j++){
                if (A[i] < A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}