package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02931 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static char[][] map;
	static int R, C, row, col, direction;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		for (int r = 0; r < R; r++) {
			String S = br.readLine();
			map[r] = S.toCharArray();
		}
		
		// 시작 위치 탐색
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'M') {
					row = r;
					col = c;
					break;
				}
			}
		}
		
		int tr, tc;
		for (int i = 0; i < 4; i++) {  // 시작 위치에서 이동 가능한 방향을 탐색해줘야한다.
			tr = row + delta[i][0];
			tc = col + delta[i][1];
			if (isIn(tr, tc)) {  // 이동이 가능하다면
				if (i == 0) {  // 위로 이동 가능한 경우
					if (map[tr][tc] == '|' || map[tr][tc] == '+' || map[tr][tc] == '1' || map[tr][tc] == '4') {
						move(i, map[tr][tc]);
					} 
				} else if(i == 1) { // 우로 이동 가능한 경우
					if (map[tr][tc] == '-' || map[tr][tc] == '+' || map[tr][tc] == '3' || map[tr][tc] == '4') {
						move(i, map[tr][tc]);
					} 
				} else if (i == 2) {  // 하로 이동 가능한 경우
					if (map[tr][tc] == '|' || map[tr][tc] == '+' || map[tr][tc] == '2' || map[tr][tc] == '3') {
						move(i, map[tr][tc]);
					} 
				} else {  // 좌로 이동 가능한 경우
					if (map[tr][tc] == '-' || map[tr][tc] == '+' || map[tr][tc] == '1' || map[tr][tc] == '2') {
						move(i, map[tr][tc]);
					}
				}
			}
		}
		
		while (map[row][col] != 'Z') {
			System.out.println(direction);
			tr = row + delta[direction][0];
			tc = col + delta[direction][1];
			if (map[tr][tc] == '.') {
				sb.append(tr+1).append(" ").append(tc+1).append(" ");
				row = tr;
				col = tc;
				for (int i = 0; i < 4; i++) {
					if (i == (direction+2) % 4) {
						continue;
					}
					tr = row + delta[i][0];
					tc = col + delta[i][1];
					if (isIn(tr, tc)) {
						if (i == 0) {  // 위로 이동 가능한 경우
							if (map[tr][tc] == '|' || map[tr][tc] == '+' || map[tr][tc] == '1' || map[tr][tc] == '4') {
								check(i);
							} 
						} else if(i == 1) { // 우로 이동 가능한 경우
							if (map[tr][tc] == '-' || map[tr][tc] == '+' || map[tr][tc] == '3' || map[tr][tc] == '4') {
								check(i);
							} 
						} else if (i == 2) {  // 하로 이동 가능한 경우
							if (map[tr][tc] == '|' || map[tr][tc] == '+' || map[tr][tc] == '2' || map[tr][tc] == '3') {
								check(i);
							} 
						} else {  // 좌로 이동 가능한 경우
							if (map[tr][tc] == '-' || map[tr][tc] == '+' || map[tr][tc] == '1' || map[tr][tc] == '2') {
								check(i);
							}
						}
					}
				}
				break;
			}
			
			move(direction, map[tr][tc]);
		}
		System.out.println(sb);
	}
	
	private static void move(int d, char cmd) {
		switch (cmd) {
			case '|':  // 왔던 방향으로 다시 나가야한다.
				row += delta[d][0];
				col += delta[d][1];
				direction = d;
				break;
			case '-':  // 왔던 방향으로 다시 나가야한다.
				row += delta[d][0];
				col += delta[d][1];
				direction = d;
				break;
			case '+':  // 왔던 방향으로 다시 나가야한다.
				row += delta[d][0];
				col += delta[d][1];
				if (d == 0 || d == 2) {
					map[row][col] = '-';
				} else {
					map[row][col] = '|';
				}
				
				direction = d;
				break;
			case '1':
				if (d == 0) {
					direction = d+1;
				} else {
					direction = d-1;
				}
				row += delta[d][0];
				col += delta[d][1];
				break;
			case '2': 
				row += delta[d][0];
				col += delta[d][1];
				if (d == 3) {
					direction = d-3;
				} else {
					direction = d-1;
				}	
				break;
			case '3':
				row += delta[d][0];
				col += delta[d][1];

				if (d == 1) {
					direction = d-1;
				} else {
					direction = d+1;
				}	
				break;
			case '4':
				row += delta[d][0];
				col += delta[d][1];
				if (d == 0) {
					direction = d+3;
				} else {
					direction = d+1;
				}	
				break;
		}
	}
	
	private static void check(int d) {
		if (direction == 0) {
			if (d == 0) {
				sb.append("|");
			} else if (d == 1) {
				sb.append("1");
			} else if (d == 3) {
				sb.append("4");
			} 
		}
		
		if (direction == 1) {
			if (d == 0) {
				sb.append("3");
			} else if (d == 1) {
				sb.append("-");
			} else if (d == 2) {
				sb.append("4");
			} 
		}
		
		if (direction == 2) {
			if (d == 1) {
				sb.append("2");
			} else if (d == 2) {
				sb.append("|");
			} else if (d == 3) {
				sb.append("3");
			} 
		}
		
		if (direction == 3) {
			if (d == 0) {
				sb.append("2");
			} else if (d == 1) {
				sb.append("-");
			} else if (d == 2) {
				sb.append("1");
			} 
		}
	}
	
	private static boolean isIn(int tr, int tc) {
		return tr >= 0 && tr < R && tc >= 0 && tc < C;
	}
}
