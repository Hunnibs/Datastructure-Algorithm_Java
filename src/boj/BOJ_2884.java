package boj;

import java.util.Scanner;

public class BOJ_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if (M-45 < 0) {
			H -= 1;
			if (H == -1) {
				H = 23;
			}
			M += (60 -45);
		} else {
			M -= 45;
		}
		System.out.printf("%d %d", H, M);
	}

}
