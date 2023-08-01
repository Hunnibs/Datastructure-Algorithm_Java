package boj;

import java.util.Scanner;

public class BOJ_02675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			sb = new StringBuilder();
			int R = sc.nextInt();
			String p = sc.next();
			
			for (int j = 0; j < p.length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(p.charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
	}

}
