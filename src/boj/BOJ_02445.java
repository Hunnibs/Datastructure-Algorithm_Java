package boj;

import java.util.Scanner;

public class BOJ_02445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num = 0;
		
		for(int i = 1; i < 2*N; i++) {
			if (i <= N) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2*N-2*i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
			else {
				for (int j = 0; j < 2*N-i; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2*i-2*N; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2*N-i; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}
	}

}
