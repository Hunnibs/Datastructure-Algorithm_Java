package boj.gold4;
/**

- @author 이병헌
- @since 2023. 8. 22.
- @see https://www.acmicpc.net/problem/15683
- @git
- @youtube
- @performance
- @category # DFS
- @note
1 - 단방향, 2 - 양방향, 3 - 직각, 4 - 삼방, 5 - 사방, 6 - 벽
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static class CameraInfo{
		int num, row, col;

		public CameraInfo(int num, int row, int col) {
			this.num = num;
			this.row = row;
			this.col = col;
		}

		public CameraInfo(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, answer = Integer.MAX_VALUE;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] office;
	static ArrayList<CameraInfo> cameras = new ArrayList<>();
	static Stack<CameraInfo> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		// input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[][] cctv = new boolean[N][M];
		office = new int[N][M];
		for (int r = 0; r < N; r++){
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++){
				office[r][c] = Integer.parseInt(st.nextToken());
				if (office[r][c] >= 1 && office[r][c] <= 5){
					cameras.add(new CameraInfo(office[r][c], r, c));
					cctv[r][c] = true;
				}
				if (office[r][c] == 6){
					cctv[r][c] = true;
				}
			}
		}

		// main
		search(0, cctv);
		System.out.println(answer);
	}

	private static void dfs(CameraInfo camera, int d, boolean[][] visited){
		int tr, tc;
		stack.add(new CameraInfo(camera.row, camera.col));

		CameraInfo temp;
		while(!stack.isEmpty()){
			temp = stack.pop();
			tr = temp.row + delta[d][0];
			tc = temp.col + delta[d][1];
			if (isIn(tr, tc) && office[tr][tc] < 6){
				visited[tr][tc] = true;
				stack.add(new CameraInfo(tr, tc));
			}
		}
	}

	private static void search(int idx, boolean[][] cctv){
		if (idx == cameras.size()){
			check(cctv);
			return;
		}

		CameraInfo camera = cameras.get(idx);
		switch (camera.num){
			case 1:
				for (int i = 0; i < 4; i++){
					boolean[][] visited = new boolean[N][M];
					for (int r = 0; r < N; r++){
						visited[r] = cctv[r].clone();
					}
					dfs(camera, i, visited);
					search(idx+1, visited);
				}
				break;
			case 2:
				for (int i = 0; i < 2; i++){
					boolean[][] visited = new boolean[N][M];
					for (int r = 0; r < N; r++){
						visited[r] = cctv[r].clone();
					}
					dfs(camera, i, visited);
					dfs(camera, i+2, visited);
					search(idx+1, visited);
				}
				break;
			case 3:
				for (int i = 0; i < 4; i++){
					boolean[][] visited = new boolean[N][M];
					for (int r = 0; r < N; r++){
						visited[r] = cctv[r].clone();
					}
					dfs(camera, i, visited);
					dfs(camera, (i+1) % 4, visited);
					search(idx+1, visited);
				}
				break;
			case 4:
				for (int i = 0; i < 4; i++){
					boolean[][] visited = new boolean[N][M];
					for (int r = 0; r < N; r++){
						visited[r] = cctv[r].clone();
					}
					dfs(camera, i, visited);
					dfs(camera, (i+1) % 4, visited);
					dfs(camera, (i+2) % 4, visited);
					search(idx+1, visited);
				}
				break;
			case 5:
				for (int i = 0; i < 1; i++){
					boolean[][] visited = new boolean[N][M];
					for (int r = 0; r < N; r++){
						visited[r] = cctv[r].clone();
					}
					dfs(camera, i, visited);
					dfs(camera, i+1, visited);
					dfs(camera, i+2, visited);
					dfs(camera, i+3, visited);
					search(idx+1, visited);
				}
				break;
		}
	}

	private static void check(boolean[][] cctv){
		int cnt = 0;
		for(int r = 0; r < N; r++){
			for (int c= 0; c < M; c++){
				if (!cctv[r][c]){
					cnt++;
				}
			}
		}

		answer = Math.min(answer, cnt);
	}

	private static boolean isIn(int row, int col){
		return row >= 0 && row < N && col >= 0 && col < M;
	}
}