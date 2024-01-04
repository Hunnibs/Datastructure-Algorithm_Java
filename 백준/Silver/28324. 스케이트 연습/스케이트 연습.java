import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2024-01-04
- @see https://www.acmicpc.net/problem/28234
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 1024MB
- @category # Greedy
- @note */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 1;
        int cur = 1;
        for (int i = N-2; i >= 0; i--) {
            if (V[i] > cur){
                sum += ++cur;
            } else if (V[i] == cur){
                sum += cur;
            } else{
                cur = V[i];
                sum += cur;
            }
        }

        System.out.println(sum);
    }
}