package boj.bronze3;

import java.util.Scanner;

public class BOJ_02441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				if (j < i) {
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}

}
