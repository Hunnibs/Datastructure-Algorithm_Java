package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, answer;
	static char[][] board;
	static boolean[][] visited;
	static boolean[] alpha = new boolean[27];  // 알파벳 중복 방문하지 않도록 관리
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		board = new char[R][];  // 원래 지도
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			board[r] = s.toCharArray();
		}
		
		visited[0][0] = true;
		alpha[board[0][0] - 'A'] = true;
		dfs(0, 0, 0);
		System.out.println(answer+1);
	}
	
	private static void dfs(int row, int col, int count) {
		int tr, tc;
		for (int i = 0; i < 4; i++) {
			tr = row + delta[i][0];
			tc = col + delta[i][1];
			if (isIn(tr, tc) && !alpha[board[tr][tc] - 'A'] && !visited[tr][tc]) {
				visited[tr][tc] = true;
				alpha[board[tr][tc] - 'A'] = true;
				dfs(tr, tc, count+1);
				visited[tr][tc] = false;
				alpha[board[tr][tc] - 'A'] = false;
			}
		}
		
		answer = Math.max(answer, count);
	}
	
	private static boolean isIn(int row, int col) {
		return row >= 0 && row < R && col >= 0 && col < C;
	}
}
