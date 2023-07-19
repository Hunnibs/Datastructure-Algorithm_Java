package boj;

import java.util.Scanner;

public class BOJ_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			String num = Integer.toString(i);
			int sum = i;
			for(int j = 0; j<num.length();j++) {
				sum += num.charAt(j) - '0';
			}
			if (sum == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
