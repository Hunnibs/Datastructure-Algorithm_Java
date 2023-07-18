package boj;

import java.util.Scanner;

public class BOJ_2443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		for (int i = A; i > 0; i--) {
			for (int j = 0; j < A; j++) {
				if (j < A-i) {
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
			}
			for (int j = 1; j < A; j++) {
				if (j < i) {
					System.out.print('*');
				} 
			}
			System.out.println();
		}
	}
}
