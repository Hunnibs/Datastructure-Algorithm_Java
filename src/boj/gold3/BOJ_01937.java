package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 11.
@see acmicpc.net/problem/1937
@git
@youtube
@performance
@category # DFS # Dynamic Programming
@note 
특정 노드보다 더 큰 값을 저장하고 있는 노드가 있다면 탐색을 계속해서 진행해준다.
이 값을 해당 노드의 DP Table에 저장을 해주고 만약 다른 노드에서 탐색을 하다가 이미 탐색을 했던 노드에 도달한다면 DP Table에 있는 최대 탐색 횟수를 플러스 해주면된다. 
*/

public class BOJ_01937 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] bamboo;
	static int[][] dp;
	
	static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		bamboo = new int[N][N];
		dp = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				bamboo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// main
		for (int r = 0; r < N; r++) {
			for (int c =0; c < N; c++) {
				if (dp[r][c] == 0) {
					dfs(r, c);
				}
			}
		}
		
		// output
		int answer = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c =0; c < N; c++) {
				answer = Math.max(answer, dp[r][c]);
			}
		}
		
		System.out.println(answer+1);
	}
	
	private static int dfs(int row, int col) {
		int tr, tc;
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			tr = row + delta[i][0];
			tc = col + delta[i][1];
			if(isIn(tr, tc) && bamboo[tr][tc] > bamboo[row][col]) {
				if (dp[tr][tc] == 0) {
					sum = Math.max(sum, dfs(tr, tc));
				} else {
					sum = Math.max(sum, dp[tr][tc]+1);
				}
			}
		}
		dp[row][col] = sum;
		
		return sum+1;
	}
	
	private static boolean isIn(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
