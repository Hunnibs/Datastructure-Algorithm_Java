package boj.silver2;

/**

@author 이병헌
@since 2023. 8. 3.
@see https://www.acmicpc.net/problem/2961
@git
@youtube
@performance O(N^2)
@category # 부분 집합
@note 
재료 N개 (0 < N <= 10)
곱연산 S, 합연산 B
신맛 정보 sour[N], 쓴맛 정보 bitter[N]
abs(S-B)가 최소가 되는 경우를 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, S, B, answer;
	static int[] sour, bitter;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = Integer.MAX_VALUE;
		subset(0, 0);
		System.out.println(answer);
	}
	
	private static void subset(int idx, int cnt) {
		if (idx == N) {
			if (cnt > 0) {
				S = 1;
				B = 0;
				for (int i = 0; i < N; i++) {
					if(visited[i]) {
						S *= sour[i];
						B += bitter[i];
					}
				}
				answer = Math.min(answer, Math.abs(S-B));
			}
			return;
		}
		
		visited[idx] = true;
		subset(idx+1, cnt+1);
		visited[idx] = false;
		subset(idx+1, cnt);
	}
}
