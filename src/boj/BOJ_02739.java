package boj;

import java.util.Scanner;

public class BOJ_02739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n",N, i, i*N);
		}
	}
}
