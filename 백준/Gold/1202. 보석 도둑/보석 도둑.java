/**

@author 이병헌
@since 2023. 8. 17.
@see
@git
@youtube
@performance
@category # Greedy
@note */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Info{
		int M, V;

		public Info(int m, int v) {
			super();
			M = m;
			V = v;
		}

		@Override
		public String toString() {
			return "Info [M=" + M + ", V=" + V + "]";
		}
		
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static long answer = 0;
	static PriorityQueue<Info> gems = new PriorityQueue<>(new Comparator<Info>() {

		@Override
		public int compare(Info o1, Info o2) {
			// TODO Auto-generated method stub
			if (o1.M == o2.M) {
				return o1.V - o2.V;
			}
			return o1.M-o2.M;
		}
	});
	static PriorityQueue<Integer> tmps;
	static ArrayList<Integer> bags = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gems.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		
		// main		
		Collections.sort(bags);
		tmps = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < K; i++) {
			int maxSize = bags.get(i);
			search(maxSize);
		}
		
		System.out.println(answer);
	}

	private static void search(int maxSize) {
		while (!gems.isEmpty()) {
			if (gems.peek().M <= maxSize) { 
				tmps.add(gems.poll().V);
			} else {
				break;
			}
		}
		
		if(tmps.isEmpty()) {
			return;
		}
		
		answer += tmps.poll();
	}
}