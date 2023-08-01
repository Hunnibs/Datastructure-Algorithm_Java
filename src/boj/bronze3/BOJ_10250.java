package boj.bronze3;

import java.util.Scanner;

public class BOJ_10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt(), W = sc.nextInt(), N = sc.nextInt();
			int cnt = 1;
			while (N > H) {
				N -= H;
				cnt++;
			}
			System.out.println(N*100 + cnt);
		}
	}

}
