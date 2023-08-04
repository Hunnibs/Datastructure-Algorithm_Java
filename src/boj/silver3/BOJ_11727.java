package boj.silver3;

/**

@author 이병헌
@since 2023. 8. 3.
@see https://www.acmicpc.net/problem/11727
@git
@youtube
@performance O(N)
@category # DP
@note 
2 * N의 타일링을 할 때 주어진 타일이 2 x 1, 2 x 2, 1 x 2 일 때,
N번째의 타일은 N-1번째에 가능한 타일 방법에 2 x 1을 붙이고 N-2번째에 가능한 타일 방법에 2 x 2 혹은 1 x 2 두 개를 붙이는 방법을 더한 값이다. 
문제를 풀 때는 오버플로에 주의하라고 % 10007을 하라는 친절함이 존재한다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11727 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		
		if (N == 1) {
			System.out.println(1);
		} else if (N == 2) {
			System.out.println(3);
		} else {
			dp[1] = 1;
			dp[2] = 3;
			for (int i = 3; i <= N; i++) {
				dp[i] = ((dp[i-1] + (dp[i-2] * 2))  % 10007);
			}
			System.out.println(dp[N]);
		}
	}
}
