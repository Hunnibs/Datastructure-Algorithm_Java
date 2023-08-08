package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, R; 
	static int row, col, d;
	static int tr, tc, tro, tco, trd, tcd;
	static int[][] original;
	static int[][] duplicate;
	static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		original = new int[N][M];
		duplicate = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				original[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		//main
		int tmp = Math.min(N, M);
		for (int i = 0; i < tmp / 2; i++) {
			findEndPoint(i);
			rotate(i);
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(duplicate[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void rotate(int idx) {
		int rowO = idx;
		int colO = idx;
		int dO = 0;
		
		int rowD = row;
		int colD = col;
		int dd = d;
		
		for(int i = 0; i < 2 * (N- 2 * idx) + 2 * (M-2 * idx-2); i++) {
			tro = rowO + delta[dO][0];
			tco = colO + delta[dO][1];
			if (!isInO(idx)) {
				if (++dO > 3) {
					dO = 0;
				}
				tro = rowO + delta[dO][0];
				tco = colO + delta[dO][1];
			}
			rowO = tro;
			colO = tco;
			
			trd = rowD + delta[dd][0];
			tcd = colD + delta[dd][1];
			if (!isInD(idx)) {
				if (++dd > 3) {
					dd = 0;
				}
				trd = rowD + delta[dd][0];
				tcd = colD + delta[dd][1];
			}
			rowD = trd;
			colD = tcd;
			duplicate[rowD][colD] = original[rowO][colO]; 
		}
	}
	
	private static void findEndPoint(int idx) {
		row = idx;
		col = idx;
		d = 0;
		int newRotate = R % (2 * (N- 2 * row) + 2 * (M-2 * col-2));
		
		for(int i = 0; i < newRotate; i++) {
			tr = row + delta[d][0];
			tc = col + delta[d][1];
			if (!isIn(idx)) {
				if (++d > 3) {
					d = 0;
				}
				tr = row + delta[d][0];
				tc = col + delta[d][1];
			}
			row = tr;
			col = tc;
		}
	}
	
	private static boolean isIn(int idx) {
		if (tr >= idx && tr < N-idx && tc >= idx && tc < M-idx) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean isInO(int idx) {
		if (tro >= idx && tro < N-idx && tco >= idx && tco < M-idx) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean isInD(int idx) {
		if (trd >= idx && trd < N-idx && tcd >= idx && tcd < M-idx) {
			return true;
		} else {
			return false;
		}
	}
}
