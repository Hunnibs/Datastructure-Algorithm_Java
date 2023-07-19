package boj;

import java.util.Scanner;

public class BOJ_2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			if (Math.max(max, nums[i]) != max) {
				max = nums[i];
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx+1);
	}
}
