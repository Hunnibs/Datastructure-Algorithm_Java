package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 1.
@see
@git
@youtube
@performance
@category #Recursion
@note */

public class BOJ_15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		visited = new boolean[N];
		int[] arr2 = new int[M];
		permutation(arr2, 0);
		System.out.println(sb);
	}
	
	static void permutation(int[] arr2, final int c) {
		if(c == arr2.length) {
			for(int i = 0; i < arr2.length; i++) {
				sb.append(arr2[i] + " ");
			}
			sb.append("\n");
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr2[c] = arr[i];
					permutation(arr2, c+1);
					visited[i] = false;
				}
			}
		}
	}
}
