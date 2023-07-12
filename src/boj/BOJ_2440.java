package day1;

import java.util.Scanner;

public class BOJ_2440 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		for (int i = A; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
