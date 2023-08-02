package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Hamster {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, X, M, r, c;
	static int[][] dp;
	static int[] answer;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dp = new int[N+1][N+1];
			for (int r = 0; r < N+1; r++) {
				Arrays.fill(dp, -1);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				dp[r][c] = Integer.parseInt(st.nextToken()); 
			}
			
		}
	}

}
