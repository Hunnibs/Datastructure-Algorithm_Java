package boj.silver2;

/**

@author 이병헌
@since 2023. 8. 18.
@see https://www.acmicpc.net/problem/1260
@git
@youtube
@performance
@category # DFS # BFS
@note 
인접행렬을 구현해서 Stack과 Queue를 활용한 DFS, BFS를 구현해주었다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_01260 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, V;  // 정점, 간선, 탐색 시작 정점 번호
	static int from, to;
	static int[][] matrix;
	
	static Queue<Integer> q = new ArrayDeque<Integer>();  // BFS 탐색을 위해 필요한 자료구조
	static Stack<Integer> stack = new Stack<>();  // DFS 탐색을 위해 필요한 자료구조
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 인접 행렬을 만들어 정점과 간선 정보를 기록해준다. 
		matrix = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken())-1;
			to = Integer.parseInt(st.nextToken())-1;
			
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		DFS();
		sb.append("\n");
		BFS();
		
		System.out.println(sb);
	}
	
	private static void BFS() {
		boolean[] visited = new boolean[N];
		
		// DFS와는 다르게 처음부터 방문을 했다는 것을 표시하고 시작한다.
		visited[V-1] = true;
		q.offer(V-1);
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current+1).append(" ");
			
			for (int i = 0; i < N; i++) {  // 해당 정점과 연결되있는 정점들의 정보를 차례대로 Queue에 넣어준다. 다음 탐색으로 넘어가려면 현재 들어온 정점들에 대한 탐색을 모두 진행한 뒤에 넘어가게 된다.
				if (matrix[current][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	private static void DFS() {
		boolean[] visited = new boolean[N];
		
		stack.add(V-1);  // 시작 정점을 넣어주고 시작한다.
		while(!stack.isEmpty()) {
			int current = stack.pop();
			
			if (!visited[current]) {  // 정점을 아직 탐색하지 않았을 경우에만 탐색했다고 설정해주고 탐색할 수 있는 것들을 stack에 넣어준다. 
				sb.append(current+1).append(" ");
				visited[current] = true;  
				
				for (int i = N-1; i >= 0; i--) {  // 순서대로 탐색해야하므로 연결된 노드 중 가장 작은 정점부터 다시 탐색할 수 있도록 뒤에서부터 탐색해준다.
					if (matrix[current][i] == 1) {
						stack.add(i);
					}
				}
			}
		}
	}
}
