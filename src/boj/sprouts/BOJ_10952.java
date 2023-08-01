package boj.sprouts;

import java.util.Scanner;

public class BOJ_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if (A + B == 0) {
				break;
			}
			System.out.println(A+B);
		}
	}
}
