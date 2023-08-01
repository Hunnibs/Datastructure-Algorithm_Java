package boj.sprouts;

import java.util.Scanner;

public class BOJ_02438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
