import java.util.*;
import java.io.*;

public class Main {
	private static final int N = 12;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[N];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 1; i < N; i++) {
			if (i + 1 < N)
				dp[i + 1] += dp[i];
			if (i + 2 < N)
				dp[i + 2] += dp[i];
			if (i + 3 < N)
				dp[i + 3] += dp[i];
		}

		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int T = 0; T < testCase; T++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}