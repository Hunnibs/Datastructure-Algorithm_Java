package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15650 {
	static int[] arr;
	static int[] numbers;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		numbers = new int[M];
		combination(0, 0);
	}

	// 조합
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
}
