package boj;

import java.util.Scanner;

public class BOJ_02588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		String B = sc.next();
		
		int sum = 0;
		for (int i = B.length()-1; i >= 0; i--) {
			int num = B.charAt(i)-'0';
			System.out.println(A * num);
			sum += ((A*num) * (int)Math.pow(10, 3-i-1));
		}
		System.out.println(sum);
	}
}
