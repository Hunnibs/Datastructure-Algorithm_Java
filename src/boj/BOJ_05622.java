package boj;

import java.util.Scanner;

public class BOJ_05622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] nums = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		String words = sc.next();
		int sum = 0;
		for (int i = 0; i < words.length(); i++) {
			for (int j = 0; j < nums.length; j++) {
				if(nums[j].contains(Character.toString(words.charAt(i)))){
					sum += (j+3);
					break;
				}
			}
		}
		System.out.println(sum);
	}

}
