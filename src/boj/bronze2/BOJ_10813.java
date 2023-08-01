package boj.bronze2;

import java.util.Scanner;

public class BOJ_10813 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] basket = new int[N];
		for (int x = 0; x < N; x++) {
			basket[x] = x+1;
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			
			int tmp = basket[a];
			basket[a] = basket[b];
			basket[b] = tmp;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(basket[i] + " ");
		}
	}

}
