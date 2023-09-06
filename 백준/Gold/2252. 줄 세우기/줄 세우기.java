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

public class Main {
	static class Node{
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node{" +
					"vertex=" + vertex +
					", next=" + next +
					'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] degree;
	static Node[] adjList;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 정점과 간선 관계 정보 && 차수 정보 기록
		adjList = new Node[N+1];
		degree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			degree[to]++;
		}

//		for (int i = 0; i < N; i++){
//			System.out.println(adjList[i]);
//		}
		
		// 차수가 0인 것들은 큐에 담아준다.
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}
		
		topologicalSort();
		System.out.println(sb);
	}
	
	private static void topologicalSort() {
		int start;
		while(!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start).append(" ");

			for(Node temp = adjList[start]; temp != null; temp = temp.next){
				degree[temp.vertex]--;
				if (degree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}
	}
}