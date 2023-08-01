package boj.bronze5;

import java.util.Scanner;

public class BOJ_25314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		while (N > 0) {
			N -= 4;
			cnt += 1;
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}

}
