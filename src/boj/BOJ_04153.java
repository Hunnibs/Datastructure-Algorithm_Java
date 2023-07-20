package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_04153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int[] nums = new int[3];
			for (int i =0; i< 3; i++) {
				nums[i] = sc.nextInt();
			}
			if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
				break;
			} else {
				Arrays.sort(nums);
				if (Math.pow(nums[2], 2) == (Math.pow(nums[0], 2) + Math.pow(nums[1], 2))) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
		}
	}

}
