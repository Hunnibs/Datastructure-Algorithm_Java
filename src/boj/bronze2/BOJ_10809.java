package boj.bronze2;

import java.util.Scanner;

public class BOJ_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		char[] s_arr = new char[S.length()];
		int[] arr = new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < S.length(); i++) {
			s_arr[i] = S.charAt(i);
		}
		
		for (int i = 0; i < s_arr.length; i++) {
			if (arr[s_arr[i]-97] == -1) {
				arr[s_arr[i]-97] = i;
			} else {
				continue;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");			
		}
	}
}
