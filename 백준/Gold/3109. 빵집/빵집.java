/**

@author 이병헌
@since 2023. 8. 16.
@see https://www.acmicpc.net/problem/3109
@git
@youtube
@performance
@category # Backtracking
@note */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C, answer;
	static boolean flag;
	static char[][] map;
	static boolean[][] visited;
	static int[][] delta = {{-1, 1}, {0, 1}, {1, 1}}; 
	
	public static void main(String[] args) throws IOException{
		// input
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < s.length(); c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		// main
		for (int r = 0; r < R; r++) {
			flag = true;
			sol(r, 0);
		}
		
		System.out.println(answer);
	}
	
	private static void sol(int row, int col) {
		if (col == C-1) {  // 가장 우측까지 파이프를 연결했다면 
			flag = false;
			answer++;
			return;
		} else {
			for (int i = 0; i < 3; i ++) {
				int tr = row + delta[i][0];
				int tc = col + delta[i][1];
				if (isIn(tr, tc) && isAvailable(tr, tc) && flag){
					visited[tr][tc] = true;
					sol(tr, tc);
				}
			}
		}
	}
	
	private static boolean isAvailable(int row, int col) {  // 해당 칸으로 이동할 수 있는지 여부를 판별
		return !visited[row][col] && map[row][col] == '.';
	}
	
	private static boolean isIn(int row, int col) {  // 보드 밖으로 나가지 않도록 관리
		return row < R && row >= 0 && col < C && col >= 0;
	}
}