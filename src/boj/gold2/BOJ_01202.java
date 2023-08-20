package boj.gold2;

/**

@author 이병헌
@since 2023. 8. 17. ~ 2023. 8. 18
@see https://www.acmicpc.net/problem/1202
@git
@youtube
@performance
@category # Greedy # Priority Queue
@note 
가방은 무게 순으로 정렬해주고 보석은 무게가 낮은 순으로 정렬해주되 무게가 같은 경우는 가치 순으로 정렬해준다. 
이 후 tmps라는 우선순위 큐에 가치만을 저장해준다. 해당 방식은 가방의 무게 순으로 탐색이 들어가기 때문에 이전 가방에 못 들어갔던 가치가 높은 보석은 다음 가방에는 무조건 들어갈 수 있다.
이런 방식으로 탐색을 최소화해서 시간초과를 해결해준다. 
*/

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

public class BOJ_01202 {
	static class Info{
		int M, V;

		public Info(int m, int v) {
			super();
			M = m;
			V = v;
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
	static PriorityQueue<Integer> tmps = new PriorityQueue<>(Collections.reverseOrder());
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
			search(bags.get(i));
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
