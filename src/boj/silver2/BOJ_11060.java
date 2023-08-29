package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-29
 * - @see
 * - @git
 * - @youtube
 * - @performance
 * - @category # DFS # Brute Force
 * - @note
 */
public class BOJ_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] maze = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i =0 ; i < N; i++){
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1001);
        dp[N-1] = 0;

        int flag = 0;
        for (int i = N-2; i >= 0; i--){
            for (int j = i+1; j <= i+maze[i]; j++){
                if (j == N){
                    break;
                }

                dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }

        if (dp[0] > 1000){
            System.out.println(-1);
        } else{
            System.out.println(dp[0]);
        }
    }
}
