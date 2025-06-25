import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] convention = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			convention[i][0] = Integer.parseInt(st.nextToken());
			convention[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(convention, (a, b) -> Integer.compare(b[1], a[1]));

		Deque<Integer> stack = new ArrayDeque<>();
		for(int[] times : convention) {
			if (stack.isEmpty())
				stack.offerLast(times[0]);

			if (stack.peekLast() < times[1]) {
				if (stack.peekLast() > times[0])
					continue;
				else {
					stack.pollLast();
					stack.offerLast(times[0]);
				}
			} else
				stack.offerLast(times[0]);
		}

		System.out.println(stack.size());
	}
}