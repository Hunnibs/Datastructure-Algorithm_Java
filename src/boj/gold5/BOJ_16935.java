package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 이병헌
 * @since 2023. 8. 9.
 * @see https://www.acmicpc.net/problem/16935
 * @git
 * @youtube
 * @performance
 * @category # Implemetation
 * @note 1. 상하반전 2. 좌우반전 3. 90도 우측 회전 4. 90도 좌측 회전 5. 사분면 시계방향 회전 6. 사분면 반시계방향
 *       회전
 * 
 *       100 x 100 배열에서 회전 횟수는 최대 1000번이 주어지는데 시간 2초, 메모리 512MB로 알고리즘 적인것이 아니라
 *       구현문제일 것이라고 판단.
 */

public class BOJ_16935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] original, duplicate;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		original = new int[N][M];
		duplicate = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				original[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// main
		while (st.hasMoreTokens()) {
			int cond = Integer.parseInt(st.nextToken());
			switch (cond) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				quadrantRotateRight();
				break;
			case 6:
				quadrantRotateLeft();
				break;
			}
		}

		// main
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(original[r][c]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void quadrantRotateLeft() {
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				duplicate[r][c] = original[r][c+M/2];
				duplicate[r+N/2][c] = original[r][c];
				duplicate[r+N/2][c+M/2] = original[r+N/2][c];
				duplicate[r][c+M/2] = original[r+N/2][c+M/2];
			}
		}
		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}

	private static void quadrantRotateRight() {
		for (int r = 0; r < N / 2; r++) {
			for (int c = 0; c < M / 2; c++) {
				duplicate[r][c+M/2] = original[r][c];
				duplicate[r+N/2][c+M/2] = original[r][c+M/2];
				duplicate[r+N/2][c] = original[r+N/2][c+M/2];
				duplicate[r][c] = original[r+N/2][c];
			}
		}

		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}

	private static void rotateLeft() {
		int tmp = N;
		N = M;
		M = tmp;

		duplicate = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				duplicate[r][c] = original[c][N - r - 1];
			}
		}

		original = new int[N][M];
		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}

	private static void rotateRight() {
		int tmp = N;
		N = M;
		M = tmp;

		duplicate = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				duplicate[r][c] = original[M-c-1][r];
			}
		}

		original = new int[N][M];
		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}

	private static void leftRight() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				duplicate[r][M - c - 1] = original[r][c];
			}
		}

		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}

	private static void upDown() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				duplicate[N - r - 1][c] = original[r][c];
			}
		}

		for (int r = 0; r < N; r++) {
			original[r] = Arrays.copyOf(duplicate[r], duplicate[r].length);
		}
	}
}