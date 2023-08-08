package boj.gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02042_Segment {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, K, a, h, start;
	static long b, c;
	static long[] tree;
	static long[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		h = (int)Math.ceil(Math.log(N) / Math.log(2));
		start = (int) Math.pow(2, h);
		tree = new long[start * 2];
		for (int i = start; i < start + N; i++) {
			long num = Long.parseLong(br.readLine());
			tree[i] = num;
		}
		
		for (int i = tree.length -1; i >= 1; i--) {
			tree[i / 2] += tree[i];
		}
		
		for (int i =0 ; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				update((int)b, c);
			} else if (a == 2) {
				sb.append(sum((int)b, (int)c)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void update(int idx, long value) {
		value = value - tree[start + idx - 1];
		
		for (int i = start + idx -1; i >= 1; i /= 2) {
			tree[i] += value;
		}
	}
	
	private static long sum(int from, int to) {
		from += start - 1;
		to += start - 1;
		long sum = 0;
		while (from <= to) {
			if (from % 2 == 0) {
				from /= 2;
			} else {
				sum += tree[from];
				from = (from + 1) / 2;
			}
			
			if (to % 2 == 0) {
				sum += tree[to];
				to = (to - 1) / 2;
			} else {
				to /= 2;
			}
		}
		return sum;
	}
}
