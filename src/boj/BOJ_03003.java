package boj;

import java.util.Scanner;

public class BOJ_03003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[] {1, 1, 2, 2, 2, 8};
		for (int i = 0; i < 6; i++) {
			int num = sc.nextInt();
			System.out.print((arr[i] - num) + " ");
		}
	}

}
