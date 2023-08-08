package boj.gold1;

/**

@author 이병헌
@since 2023. 8. 8.
@see https://www.acmicpc.net/problem/2042
@git
@youtube
@performance
@category #
@note */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02042_FenWick {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, K, a;
	static long b, c;
	static long[] tree;
	static long[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new long[N+1];
		arr = new long[N+1];
		for (int i = 1; i < tree.length; i++) {
			long num = Long.parseLong(br.readLine());
			makeTree(i, num);
			arr[i] = num;
		}
		
		for (int i =0 ; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				makeTree((int)b, c - arr[(int)b]);
				arr[(int)b] = c;
			} else if (a == 2) {
				sb.append(sum((int)c)-sum((int)(b-1))).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void makeTree(int idx, long value) {
		while (idx < tree.length) {
			tree[idx] += value;
			idx += idx & -idx;
		}
	}
	
	private static long sum(int idx) {
		long result = 0;
		while (idx > 0) {
			result += tree[idx];
			idx -= idx & -idx;
		}
		return result;
	}
}
