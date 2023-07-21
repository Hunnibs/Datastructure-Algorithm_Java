package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10811 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N];
		for(int i =0; i<N; i++) {
			basket[i] = i+1;
		}
		
		for(int x = 0; x < M; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			
			int[] arr2 = Arrays.copyOf(basket, N);
			int cnt = 0;
			for (int y = i; y <= j; y++) {
				basket[y] = arr2[j-cnt++];
			}
		} 
		for(int i = 0; i < N; i++) {
			System.out.print(basket[i] + " ");
		}
	}

}
