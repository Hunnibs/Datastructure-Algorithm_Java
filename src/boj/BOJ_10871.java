package boj;

import java.util.Scanner;

public class BOJ_10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num < X) {
				System.out.print(num + " ");
			}
		}
	}
}
