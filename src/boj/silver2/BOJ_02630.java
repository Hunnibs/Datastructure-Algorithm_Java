package boj.silver2;

/**

@author 이병헌
@since 2023. 8. 7.
@see https://www.acmicpc.net/problem/2630
@git
@youtube
@performance O(N^2)
@category # Recursion
@note 
배열을 작게 쪼개어 들어가면서 자를 수 있는 경우에만 해당 색종이 색깔 변수를 Counting 해준다. 
전부 다 한 칸까지 쪼개서 잘라야 하는 경우 N^2

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] paper;
	static int white = 0, blue = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// input
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		paper = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// main
		recursion(0, 0, N-1, N-1);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void recursion(int r1, int c1, int r2, int c2) {
		int tmp = paper[r1][c1];
		
		if (r2 - r1 == 0|| c2 - c1 == 0) {
			if (tmp == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		for (int r = r1; r <= r2; r++) {
			for (int c = c1; c <= c2; c++) {
				if (tmp != paper[r][c]) {
					recursion(r1, c1, (r1 + r2) / 2, (c1 + c2) / 2);
					recursion(r1, (c1 + c2) / 2 + 1, (r1 + r2) / 2, c2);
					recursion((r1 + r2) / 2 + 1, c1, r2, (c1 + c2) / 2);
					recursion((r1 + r2) / 2 + 1, (c1 + c2) / 2 + 1, r2, c2);
					return;
				}
			}
		}
		
		if (tmp == 1) {
			blue++;
		} else {
			white++;
		}
	}
}
