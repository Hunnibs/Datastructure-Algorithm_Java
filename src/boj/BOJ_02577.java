package boj;

import java.util.Scanner;

public class BOJ_02577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int sum = A * B * C;
		String nums = Integer.toString(sum);
		int[] number = new int[10];
		for (int i = 0; i < nums.length(); i++) {
			number[nums.charAt(i) - '0'] += 1;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(number[i]);
		}
	}

}
