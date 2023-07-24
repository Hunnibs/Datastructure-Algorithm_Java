package boj;

import java.util.Scanner;

public class BOJ_02743 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String words = sc.next();
    	int N = sc.nextInt();
    	
    	System.out.println(words.charAt(N-1));
    }
}
