package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01697 {
	static class Info{
		int d, depth;

		public Info(int d, int depth) {
			super();
			this.d = d;
			this.depth = depth;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, answer, tn;
	static boolean[] visited = new boolean[100001];
	static Queue<Info> queue =  new ArrayDeque<>();

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		queue.add(new Info(K, 0));
		bfs();
		
		System.out.println(answer);
	}
	
	private static void bfs() {
		Info info;
		while(!queue.isEmpty()) {
			info = queue.poll();
			if (info.d == N) {
				answer = info.depth;
				return;
			}
			if (isIn(info.d+1) && !visited[info.d+1]) {
				visited[info.d+1] = true;
				queue.add(new Info(info.d+1, info.depth+1));
			}
			if (isIn(info.d-1) && !visited[info.d-1]) {
				visited[info.d-1] = true;
				queue.add(new Info(info.d-1, info.depth+1));
			}
			if (info.d % 2 == 0 && !visited[info.d /2]) {
				visited[info.d/2] = true;
				queue.add(new Info(info.d/2, info.depth+1));
			}
		}
	}
	
	private static boolean isIn(int n) {
		return n >= 0 && n <= 100000;
	}
}
