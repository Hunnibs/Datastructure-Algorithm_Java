package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BattleField {
	static class TankInfo{
		int d, r, c;

		public TankInfo(int d, int r, int c) {
			super();
			this.d = d;
			this.r = r;
			this.c = c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int H, W;
	static char[][] map;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static TankInfo tank;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// 맵의 초기설정
			map = new char[H][W];
			for (int h = 0; h < H; h++) {
				String s = br.readLine();
				for (int w = 0; w < W; w++) {
					map[h][w] = s.charAt(w);
					// 전차의 위치와 보는 방향 정보를 받아준다. 
					if (map[h][w] == '^') {
						tank = new TankInfo(0, h, w);
					} else if (map[h][w] == 'v') {
						tank = new TankInfo(1, h, w);
					} else if (map[h][w] == '<') {
						tank = new TankInfo(2, h, w);
					} else if (map[h][w] == '>') {
						tank = new TankInfo(3, h, w);
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			
			int tr, tc;
			// 커맨드에 따라서 움직이기 시작
			for (int i = 0; i < N; i++) {
				char cmd = command.charAt(i);
				switch(cmd) {
					case 'U':
						tank.d = 0;
						tr = tank.r + delta[tank.d][0];
						tc = tank.c + delta[tank.d][1];
						if (isIn(tr, tc) && map[tr][tc] == '.') {
							map[tank.r][tank.c] = '.';  // 이동이 가능하다면 원래 있던 자리 평지로 만들어주고 이동 
							tank.r = tr;
							tank.c = tc;
						}
						map[tank.r][tank.c] = '^'; 
						break;
					case 'D':
						tank.d = 1;
						tr = tank.r + delta[tank.d][0];
						tc = tank.c + delta[tank.d][1];
						if (isIn(tr, tc) && map[tr][tc] == '.') {
							map[tank.r][tank.c] = '.';  // 이동이 가능하다면 원래 있던 자리 평지로 만들어주고 이동 
							tank.r = tr;
							tank.c = tc;
						}
						map[tank.r][tank.c] = 'v'; 
						break;
					case 'L':
						tank.d = 2;
						tr = tank.r + delta[tank.d][0];
						tc = tank.c + delta[tank.d][1];
						if (isIn(tr, tc) && map[tr][tc] == '.') {
							map[tank.r][tank.c] = '.';  // 이동이 가능하다면 원래 있던 자리 평지로 만들어주고 이동 
							tank.r = tr;
							tank.c = tc;
						}
						map[tank.r][tank.c] = '<'; 
						break;
					case 'R':
						tank.d = 3;
						tr = tank.r + delta[tank.d][0];
						tc = tank.c + delta[tank.d][1];
						if (isIn(tr, tc) && map[tr][tc] == '.') {
							map[tank.r][tank.c] = '.';  // 이동이 가능하다면 원래 있던 자리 평지로 만들어주고 이동 
							tank.r = tr;
							tank.c = tc;
						}
						map[tank.r][tank.c] = '>'; 
						break;
					case 'S':
						tr = tank.r + delta[tank.d][0];
						tc = tank.c + delta[tank.d][1];
						while (isIn(tr, tc)) {
							if (map[tr][tc] == '*') {
								map[tr][tc] = '.';
								break;
							} else if (map[tr][tc] == '#') {
								break;
							}
							tr = tr + delta[tank.d][0];
							tc = tc + delta[tank.d][1];
						}
						break;
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean isIn(int row, int col) {
		return row >= 0 && row < H && col >= 0 && col < W;
	}
}
