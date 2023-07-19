package boj;

import java.util.Scanner;

public class BOJ_1978 {
	public static Boolean solution(int num) {
		if (num == 1) {
			return false;
		}
		for (int j = 2; j <= Math.sqrt(num); j++) {
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(solution(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
