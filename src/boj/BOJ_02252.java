package boj;

/**

@author 이병헌
@since 2023. 8. 21.
@see https://www.acmicpc.net/problem/2252
@git
@youtube
@performance
@category # Topological Sort
@note 
유향 그래프에 정해진 순서가 몇 개 주어지기 때문에 위상정렬을 사용하려고 생각헀다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] degree;
	static int[][] adjMatrix;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 정점과 간선 관계 정보 기록
		adjMatrix = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			adjMatrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		// 차수 정보 기록
		degree = new int[N];
		for (int r = 0; r < N; r++) {
			int cnt = 0;
			for (int c = 0; c < N; c++) {
				if (adjMatrix[c][r] == 1) {
					cnt++;
				}
			}
			degree[r] = cnt;
		}
		
		// 차수가 0인 것들은 큐에 담아준다.
		for (int i = 0; i < N; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				degree[i]--;
			}
		}
		
		topologicalSort();
		System.out.println(sb);
	}
	
	private static void topologicalSort() {
		int start;
		while(!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start+1).append(" ");
			for (int end = 0; end < N; end++) {
				if(adjMatrix[start][end] == 1) {
					adjMatrix[start][end] = 0;
					degree[end]--;
				}
			}
			
			for (int i = 0; i < N; i++) {  // 새롭게 차수가 0이 된 것들을 넣어준다.
				if (degree[i] == 0) {
					queue.offer(i);
					degree[i]--;
				}
			}
		}
	}
}
