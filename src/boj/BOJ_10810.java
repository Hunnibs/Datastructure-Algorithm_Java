package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10810 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] basket = new int[N];
		for (int num = 0; num < M; num++) {
			int i, j, k;
			i = sc.nextInt();
			j = sc.nextInt();
			k = sc.nextInt();
			for (int x = i; x <= j; x++) {
				basket[x]++;
			}
		}
		System.out.println(Arrays.toString(basket));
	}

}
