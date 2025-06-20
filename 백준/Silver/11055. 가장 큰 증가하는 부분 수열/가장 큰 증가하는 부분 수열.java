import java.util.*;
	import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[N];
		long answer = 0; // 최소한 하나의 원소는 포함하므로 0으로 초기화해도 됨

		// dp 배열 초기화 및 계산
		for (int i = 0; i < N; i++) {
			dp[i] = nums[i]; // 자기 자신으로 이루어진 수열의 합으로 초기화
			for (int j = 0; j < i; j++) { // i 이전의 모든 원소들을 탐색
				if (nums[i] > nums[j]) { // nums[i]가 nums[j]보다 큰 경우에만 증가 부분 수열 가능
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
				}
			}
			// 매번 dp[i]가 계산될 때마다 answer와 비교하여 최댓값 갱신
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}