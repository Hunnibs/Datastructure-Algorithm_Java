package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 10.
@see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYlH3z4K78kDFAVR&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AYnN7JhqMPoDFAUe&type=PROBLEM&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=7
@git
@youtube
@performance
@category # Dynamic Programming
@note 
백준 평범한 배낭 문제와 동일
*/

public class HamDiet_DP {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][L+1];
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				for (int c = 1; c <= L; c++) {
					if (c < k) {
						dp[r][c] = dp[r-1][c];
					} else {
						dp[r][c] = Math.max(t + dp[r-1][c-k], dp[r-1][c]);
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(dp[N][L]).append("\n");
		}
		System.out.println(sb);
	}
}
