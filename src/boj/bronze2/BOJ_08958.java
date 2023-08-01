package boj.bronze2;

import java.util.Scanner;

public class BOJ_08958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i< N; i++) {
			int cnt = 1;
			int sum = 0;
			String scores = sc.next();
			for (int j = 0; j<scores.length();j++) {
				if(scores.charAt(j) == 'O') {
					sum += cnt++; 
				}else {
					cnt = 1;
				}
			}
			System.out.println(sum);
		}
	}

}
