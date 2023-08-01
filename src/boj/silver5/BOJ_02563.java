package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02563 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] board = new int[100][100];
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken()), row = Integer.parseInt(st.nextToken());
			for (int r = row; r < row+10; r++) {
				for (int c = col; c < col+10; c++) {
					board[r][c] = 1;
				}
			}
		}
		
		int sum = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (board[r][c] == 1) {
					sum += 1;
				}
			}
		}
		System.out.println(sum);
	}
}
