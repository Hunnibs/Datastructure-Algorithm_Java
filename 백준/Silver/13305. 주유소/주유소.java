import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/6/24
- @see https://www.acmicpc.net/problem/13305
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 512MB
- @category # Greedy
- @note */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N-1];
        int[] price = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // input end
        System.out.println(sol(N, distance, price));
    }

    private static int sol(int N, int[] distance, int[] price){
        // 초기값 설정 price[0]에서 distance[0]만큼을 충전해야 출발할 수 있다.
        int min = price[0];
        int sum = distance[0] * price[0];

        for (int i = 1; i < N-1; i++) {
            if (min > price[i]){
                min = price[i];
            }

            sum += min * distance[i];
        }

        return sum;
    }
}