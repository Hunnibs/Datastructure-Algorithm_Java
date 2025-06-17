import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[16][16];
		String input = "";
		while((input = br.readLine()) != null) {
			if (input.isEmpty()) break;
			StringTokenizer st = new StringTokenizer(input);
			int black = Integer.parseInt(st.nextToken());
			int white = Integer.parseInt(st.nextToken());
			for (int b = 15; b >= 0; b--) {
				for (int w = 15; w >= 0; w--) {
					if (b != 0) {
						dp[b][w] = Math.max(dp[b-1][w] + black, dp[b][w]);
					}

					if (w != 0) {
						dp[b][w] = Math.max(dp[b][w-1] + white, dp[b][w]);
					}
				}
			}
		}

		System.out.println(dp[15][15]);
	}
}