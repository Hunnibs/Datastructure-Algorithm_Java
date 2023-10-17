package boj;

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
- @note
 나무는 1번 2번 단 두 개뿐이므로 % 연산을 통해 이동했을 때 현재 위치를 특정지을 수 있다.

 */

public class BOJ_02240 {
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
            int num = Integer.parseInt(br.readLine()) - 1;  // 어떤 나무에서 자두가 떨어지는지
            for (int j = 0; j <= W; j++) {
                if (j % 2 == num){  // 떨어지는 나무가 현재 위치와 같다면 그냥 그 위치에서 받아먹으면 됨
                    dp[i][j] = dp[i-1][j] + 1;
                } else{  // 다르면 이동해야되니까 이동했을 때와 떨어지는걸 안 받는 경우 중 더 그리디하게 받아줌
                    if (j == 0){
                        dp[i][j] = dp[i-1][j];  // 0일 때는 예외 케이스로 구분해줘야지 index out이 안터짐
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[T][W]);
    }
}
