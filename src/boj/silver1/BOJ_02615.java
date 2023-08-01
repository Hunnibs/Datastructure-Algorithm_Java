package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02615 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = new int[19][19];
	static int answer = 0;
	static int row = 0, col = 0;
	static int tr, tc;
	static int flag = 0;
	static int[][] delta = {{1, 1}, {1, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for (int r = 0; r < 19; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = check(1);
		if (answer == 0) {
			answer = check(2);
		}
		
		System.out.println(answer);
		if (answer != 0) {
			System.out.println(row + " " + col);
		}
	}
	
	// 비기면 0, 검정 승 1, 흰 승 2
	static int check(int color) {
		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if (board[r][c] == color) {
					search(r, c, color);
					if (flag == 1) {
						return color;
					}
				}
			}
		}
		return 0;
	}
	
	static void search(int r, int c, int color) {
		for (int i = 0; i < 4; i++) {
			row = r+1;
			col = c+1;
			int cnt = 1;
			if (firstCheck(r, c, color, i)) {
				tr = r;
				tc = c;
				for (int j = 0; j < 6; j++) {
					if (col > tc+1) {
						row = tr+1;
						col = tc+1;
					}
					tr = tr + delta[i][0];
					tc = tc + delta[i][1];
					if (isin()) {
						if (board[tr][tc] != color) {
							break;
						} else {
							cnt++;
						}
					} else {
						break;
					}
				}
				
				if (cnt == 5) {
					flag = 1;
					return;
				}
			}
		}
	}
	
	static Boolean isin() {
		if (tr >= 0 && tr < 19 && tc >= 0 && tc < 19) {
			return true;
		} else {
			return false;
		}
	}
	
	static Boolean firstCheck(int r, int c, int color, int i) {
		tr = r + ((-1) * delta[i][0]);
		tc = c + ((-1) * delta[i][1]);
		if (isin()) {
			if (board[tr][tc] == color) {
				return false;
			} 
		}
		return true;
	}
}
