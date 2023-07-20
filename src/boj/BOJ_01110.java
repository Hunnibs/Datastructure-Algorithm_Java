package boj;

import java.util.Scanner;

public class BOJ_01110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int tmp = N;
		int cnt = 0;
		while(true) {
			cnt++;
			int A = (int)(tmp / 10);
			int B = tmp % 10;
			int C = A + B;
			tmp = (10 * B) + (C % 10);
			if (tmp == N) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
