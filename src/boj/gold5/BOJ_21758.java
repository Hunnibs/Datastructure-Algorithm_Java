package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/24/2023
- @see https://www.acmicpc.net/problem/21758
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 512MB
- @category # SubSum
- @note */

public class BOJ_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        int[] subSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            subSum[i] = subSum[i-1] + nums[i];
        }

        // input end
        int answer = 0;
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, subSum[N] - subSum[i] + subSum[N] - subSum[1] - nums[i]);  // 벌 벌 통
            answer = Math.max(answer, subSum[i] - nums[1] + subSum[N-1] - subSum[i-1]);  // 벌 통 벌
            answer = Math.max(answer, subSum[i-1] + subSum[N-1] - nums[i]);  // 통 벌 벌
        }
        System.out.println(answer);
    }
}
