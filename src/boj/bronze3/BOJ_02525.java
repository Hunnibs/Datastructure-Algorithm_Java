package boj;

import java.util.Scanner;

public class BOJ_02525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int H, M, time, new_time;
		H = sc.nextInt();
		M = sc.nextInt();
		time = sc.nextInt();		
		new_time = M + time;
		
		while(new_time >=60) {
			new_time -= 60;
			H++;
			if (H == 24) {
				H = 0;
			}
		}
		System.out.println(H + " " + new_time);
	}

}
