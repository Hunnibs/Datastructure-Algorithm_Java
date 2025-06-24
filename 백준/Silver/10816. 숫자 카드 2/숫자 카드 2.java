import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// sol
		Arrays.sort(cards);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = nums[i];

			sb.append(upperBound(cards, num) - lowerBound(cards, num)).append(" ");
		}
		System.out.println(sb);
	}

	private static int lowerBound(int[] cards, int target) {
		int left = 0;
		int right = cards.length;

		while(left < right) {
			int mid = (left + right) / 2;

			if (cards[mid] >= target)
				right = mid;
			else
				left = mid + 1;
		}
		return right;
	}

	private static int upperBound(int[] cards, int target) {
		int left = 0;
		int right = cards.length;

		while(left < right) {
			int mid = (left + right) / 2;

			if (cards[mid] > target)
				right = mid;
			else
				left = mid + 1;
		}
		return right;
	}
}