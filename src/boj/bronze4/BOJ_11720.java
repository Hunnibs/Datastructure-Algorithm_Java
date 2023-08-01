package boj;

import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String num = sc.next();
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += (num.charAt(i) - '0');
		}
		System.out.println(sum);
	}
}
