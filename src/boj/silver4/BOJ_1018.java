package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String s;
	static char[][] board;
	static char[] bChess;
	static char[] wChess;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bChess = new char[]{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
		wChess = new char[]{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
//		bChess = new char[8];
//		wChess = new char[8];
//		for (int i = 0; i < 8; i++) {
//			if (i % 2 == 0) {
//				bChess[i] = 'B';
//				wChess[i] = 'W';
//			} else {
//				bChess[i] = 'W';
//				wChess[i] = 'B';
//			}
//		}
		
		board = new char[N][M];
		for (int r = 0; r < N; r++) {
			s = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = s.charAt(c);
			}
		} 
		
		int answer = Integer.MAX_VALUE;
		for(int r = 0; r < N-7; r++) {
			for(int c =0; c < M-7; c++) {
				answer = Math.min(answer, chess(r, c));
			}
		}
		
		System.out.println(answer);
	}
	
	static int chess(int x, int y) {
		int sum1 =0, sum2 = 0;
		for (int r = x; r < x+8; r++) {
			for (int c =y; c < y+8; c++) {
				if(r % 2 == 0) {
					if(board[r][c] != bChess[c-y]) {
						sum1++;
					}
					if(board[r][c] != wChess[c-y]) {
						sum2++;
					}
				} else {
					if(board[r][c] != bChess[c-y]) {
						sum2++;
					}
					if(board[r][c] != wChess[c-y]) {
						sum1++;
					}
				}
			}
		}
		return Math.min(sum1, sum2);
	}
}
