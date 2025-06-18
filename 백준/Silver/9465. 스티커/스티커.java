import java.util.*;
import java.io.*;

public class Main {
	private static final int row = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int s = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < s; tc++) {
			int col = Integer.parseInt(br.readLine());
			int[][] sticker = new int[row][col];
			//sticker input
			for (int r = 0; r < row; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < col; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			//sol
			if (col == 1) {
				sb.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
				continue;
			}
			int[][] dp = new int[row][col];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			dp[0][1] = dp[1][0] + sticker[0][1];
			dp[1][1] = dp[0][0] + sticker[1][1];
			for (int c = 2; c < col; c++) {
				dp[0][c] = Math.max(dp[1][c-2] + sticker[0][c], dp[1][c-1] + sticker[0][c]);
				dp[1][c] = Math.max(dp[0][c-2] + sticker[1][c], dp[0][c-1] + sticker[1][c]);
			}
			sb.append(Math.max(dp[0][col - 1], dp[1][col - 1])).append("\n");
		}
		System.out.println(sb);
	}
}