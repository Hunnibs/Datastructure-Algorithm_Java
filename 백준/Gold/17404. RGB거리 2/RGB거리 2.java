/**

- @author 이병헌
- @since 9/2/24
- @see https://www.acmicpc.net/problem/17404
- @git https://github.com/Hunnibs
- @youtube
- @performance 0.5sec 128MB
- @category #
- @note
1. 시작 집과 끝 집의 색깔은 달라야 한다.
2. 나머지 집은 i-1, i+1과 집 색깔이 달라야 한다.
 */

import java.util.*;
import java.io.*;

public class Main {
    private static int MAX = 10_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        int answer = MAX;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp(i, N, costs, dp));
        }

        System.out.print(answer);
    }

    private static int dp(int start, int N, int[][] costs, int[][] dp){
        int answer = MAX;
        for (int i = 0; i < 3; i++){
            if (i == start) dp[0][i] = costs[0][i];
            else dp[0][i] = MAX;
        }
        for (int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1] + costs[i][0], dp[i-1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + costs[i][1], dp[i-1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i-1][0] + costs[i][2], dp[i-1][1] + costs[i][2]);
        }
        for (int i = 0; i < 3; i++){
            if (i == start) continue;
            answer = Math.min(answer, dp[N-1][i]);
        }

        return answer;
    }
}