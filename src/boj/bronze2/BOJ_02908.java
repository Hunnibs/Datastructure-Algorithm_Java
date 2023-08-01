package boj.bronze2;

import java.util.Scanner;

public class BOJ_02908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next(), B = sc.next();
		
		char[] A1 = A.toCharArray();
		char[] B1 = B.toCharArray();
		
		char tmp;
		tmp = A1[0];
		A1[0] = A1[2];
		A1[2] = tmp;
		
		tmp = B1[0];
		B1[0] = B1[2];
		B1[2] = tmp;
		
		String A2 = new String(A1);
		String B2 = new String(B1);
		
		if (Integer.parseInt(A2) > Integer.parseInt(B2)) {
			System.out.println(A2);
		} else {
			System.out.println(B2);
		}
	}

}
