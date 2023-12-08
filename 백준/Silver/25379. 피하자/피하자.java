import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/9/23
- @see https://www.acmicpc.net/problem/25379
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec, 1024MB
- @category #
- @note
 left = odd or left = even
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // left = odd
        int cnt = 0;
        int oddSum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 1){
                oddSum += cnt;
            } else{
                cnt++;
            }
        }

        cnt = 0;
        int evenSum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0){
                evenSum += cnt;
            } else{
                cnt++;
            }
        }

        System.out.println(Math.min(evenSum, oddSum));
    }
}