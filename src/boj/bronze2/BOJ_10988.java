package boj;

import java.util.Scanner;

public class BOJ_10988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String words = sc.next();
		
		int answer = 1;
		for(int i = 0; i < words.length()/2; i++) {
			if (words.charAt(i) != (words.charAt(words.length()-i-1))) {
				answer = 0;
				break;
			}
		}
		System.out.println(answer);
	}

}
