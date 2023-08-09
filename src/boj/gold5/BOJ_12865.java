package boj.gold5;

/**

@author 이병헌
@since 2023. 8. 9.
@see https://www.acmicpc.net/problem/12865
@git
@youtube
@performance O(N * M)
@category # Dynamic Programming
@note 
부분집합을 만들어서 해당 케이스에 대한 가중치 합을 모두 탐색하는 경우를 먼저 생각
해당 방식은 2 ^ 10의 연산을 진행해야하므로 시간복잡도가 끔찍해서 시간 안에 통과 X

그래서 Dp방식으로 문제를 해결
2차원 Dp Table을 만들어주고 하나씩 넣어주면서 가중치 값을 비교하면서 값을 업데이트 해준다. 최종적으로 가장 마지막 칸에 갔을 때 저장되는 값이 최적의 해라는 것이 보장된다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, K;
	static int answer = Integer.MIN_VALUE;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		int w;
		int v;
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			for (int c = 0; c <= K; c++) {
				if (c < w) {
					dp[r][c] = dp[r-1][c]; 
				} else {
					dp[r][c] = Math.max(v + dp[r-1][c-w], dp[r-1][c]);
				}
			}
		}
		
		
		System.out.println(dp[N][K]);
	}
}