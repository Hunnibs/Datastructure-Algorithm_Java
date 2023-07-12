package day1;

import java.util.Scanner;

public class BOJ_2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		for (int i = A-1; i >= 0; i--) {
			for (int j = 0; j < A; j++) {
				if (j < i) {
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
			}
			for (int j = 0; j < A-i-1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
