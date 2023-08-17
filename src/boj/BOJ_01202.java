package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

		@Override
		public String toString() {
			return "Info [M=" + M + ", V=" + V + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static long answer = 0;
	static PriorityQueue<Info> infos = new PriorityQueue<>();
	static ArrayList<Integer> bags = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		
		// main		
		Collections.sort(bags);
		
		for (int i = 0; i < K; i++) {
			int maxSize = bags.get(i);
			search(maxSize);
		}

		System.out.println(answer);
	}
	
	private static void search(int maxSize) {  // 가방의 크기
		Info tmp;
		int value = -1;
		
		while(infos.peek().M <= maxSize) {
			if (value < infos.peek().V) {
				tmp = infos.poll();
			}
		}
		
		if (value != -1) {
			answer += value;
		}
	}
}
