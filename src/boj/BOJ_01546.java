package boj;

import java.util.Scanner;

public class BOJ_01546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int[] scores = new int[N];
		
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
			max = Math.max(max, scores[i]);
		}
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (double)(scores[i]) * 100 / (double)max;
		}
		
		System.out.println(sum / N);
	}

}
