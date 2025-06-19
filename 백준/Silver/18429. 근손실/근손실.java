import java.util.*;
import java.io.*;

public class Main {
	private static int N;
	private static int K;
	private static int count;
	private static final int MUSCLE = 500;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] kit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}

		//sol
		permutation(new boolean[N], kit, MUSCLE, 0);
		System.out.println(count);
	}

	private static void permutation(boolean[] visited, int[] kit, int power, int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;

			if (power + kit[i] - K < 500) continue;
			else {
				visited[i] = true;
				permutation(visited, kit, power + kit[i] - K, depth + 1);
				visited[i] = false;
			}
		}
	}
}