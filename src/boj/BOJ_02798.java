package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_02798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N];

		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}

		Arrays.sort(cards);
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if ((M - sum) >= 0 && (M-sum) < min) {
						min = M-sum;
						answer = sum;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
