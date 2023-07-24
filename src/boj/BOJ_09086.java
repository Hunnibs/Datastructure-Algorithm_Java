package boj;

import java.util.Scanner;

public class BOJ_09086 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String words = sc.next();
			char A = words.charAt(0);
			char B = words.charAt(words.length()-1);
			System.out.printf("%c%c",A, B);
			System.out.println();
		}
	}

}
