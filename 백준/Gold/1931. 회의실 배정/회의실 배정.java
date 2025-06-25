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

		int cnt = 0;
		int prev = 0;
		for(int[] times : convention) {
			if (cnt == 0) {
				prev = times[0];
				cnt++;
			}

			if (prev < times[1]) {
				if (prev > times[0])
					continue;
				else {
					prev = times[0];
				}
			} else {
				prev = times[0];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}