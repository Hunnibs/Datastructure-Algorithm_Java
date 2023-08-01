package boj.silver5;

import java.util.Scanner;

public class BOJ_02018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 1;
		int k = N / 2 + 1;
		for (int i = k; i >= 0; i--) {
			int tmp = i;
			int sum = tmp;
			while (sum <= N) {
				if (tmp == 0) {
					break;
				}
				if (sum == N) {
					cnt++;
				} 
				sum += --tmp;
			}
		}
		
		if (N == 1 || N == 2) {
			System.out.println(1);
		} else {
			System.out.println(cnt);
		}
	}

}
