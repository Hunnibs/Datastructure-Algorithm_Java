package boj.silver1;

/**

@author 이병헌
@since 2023. 8. 16.
@see https://www.acmicpc.net/problem/1992
@git
@youtube
@performance 
@category # Divide & Conquer
@note 
각 사각형 마다 가능한지 불가능한지 여부를 판단하면서 전부 탐색해준다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] board;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		for (int r = 0; r < n; r++) {
			s = br.readLine();
			for (int c = 0; c < n; c++) {
				board[r][c] = s.charAt(c) - '0';
			}
		}

		// main
		int flag = isAvailable(0, 0, n);
		if (flag != -1) {
			sb.append(flag);
		} else {
			sb.append("(");
			sol(0, 0, n / 2);
			sb.append(")");
		}
		
		System.out.println(sb);
	}
	
	private static void sol(int row, int col, int n) {
		int flag = isAvailable(row, col, n);
		if (flag != -1) {
			sb.append(flag);
		} else {
			sb.append("(");
			sol(row, col, n / 2);
			sb.append(")");
		}
		
		flag = isAvailable(row, col+n, n);
		if (flag != -1) {
			sb.append(flag);
		} else {
			sb.append("(");
			sol(row, col+n, n / 2);
			sb.append(")");
		}
		
		flag = isAvailable(row+n, col, n);
		if (flag != -1) {
			sb.append(flag);
		} else {
			sb.append("(");
			sol(row+n, col, n / 2);
			sb.append(")");
		}
		
		flag = isAvailable(row+n, col+n, n);
		if (flag != -1) {
			sb.append(flag);
		} else {
			sb.append("(");
			sol(row+n, col+n, n / 2);
			sb.append(")");
		}
	}
	
	private static int isAvailable(int row, int col, int n) {  // 하나로 통일되어있으면 그 색깔, 아니면 -1을 리턴
		int flag = board[row][col];
		for (int r = row; r < row + n; r++) {
			for (int c = col; c < col + n; c++) {
				if (board[r][c] != flag) {
					flag = -1;
					return flag;
				}
			}
		}
		return flag;
	}
}
