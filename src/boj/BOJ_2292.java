package boj;

import java.util.Scanner;

public class BOJ_2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int idx = 1;
		int plus = 6;
		int cnt = 1;
		
		while (idx < N) {
			idx += plus;
			plus += 6;
			cnt++;
		}
		System.out.println(cnt);
	}

}
