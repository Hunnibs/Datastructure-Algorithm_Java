package boj.bronze3;

import java.util.Scanner;

public class BOJ_10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			min = Math.min(min,  arr[i]);
			max = Math.max(max,  arr[i]);
		}
		
		System.out.println(min + " " + max);
	}

}
