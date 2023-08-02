package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Snail {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, d, row, col, tr, tc;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			
			row = 0;
			col = 0;
			int cnt = 1, d = 0;
			for (int i = 0; i < N * N; i++) {
				arr[row][col] = cnt++;
				tr = row + delta[d][0];
				tc = col + delta[d][1];
				if (isIn() && arr[tr][tc] == 0) {
					row = tr;
					col = tc;
				} else {
					if (++d > 3) {
						d = 0;
					}
					row += delta[d][0];
					col += delta[d][1];
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean isIn() {
		if (tr >= 0 && tr < N && tc >= 0 && tc < N) {
			return true;
		} else {
			return false;
		}
	}
	
}
