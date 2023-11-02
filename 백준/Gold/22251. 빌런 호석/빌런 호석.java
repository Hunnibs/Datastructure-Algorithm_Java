import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-11-01
- @see https://www.acmicpc.net/problem/22251
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class Main {
    static int[][] nums = {{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static int answer = 0;
    static int tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String X = st.nextToken();
        tmp = Integer.parseInt(X);

        int[] floor = new int[K];
        for (int i = 0; i < X.length(); i++) {
            floor[i] = X.charAt(X.length()-1 - i) - '0';
        }

        sol(floor, 0, K, P, 0, N);
        System.out.println(answer);
    }

    private static void sol(int[] floor, int cur, int depth, int change, int sum, int max){
        if (cur == depth){
            if (sum <= max) {
                answer++;
            }
            if (sum == 0 || sum == tmp) {
                answer--;
            }
            return;
        } else{
            for (int i = 0; i < 10; i++) {
                int num = floor[cur];
                if (change - nums[num][i] >= 0){
                    sol(floor, cur+1, depth, change-nums[num][i], sum + i * (int)Math.pow(10, cur), max);
                }
            }
        }
    }
}