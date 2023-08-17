package boj.gold5;

/**

@author 이병헌
@since 2023. 8. 8.
@see https://www.acmicpc.net/problem/16927
@git
@youtube
@performance O(N^2)
@category # Implemetation
@note 
R번 회전 시키더라도 한 사각형에서 최대로 돌 수 있는 사이클을 정해져있으므로 R번 연산 횟수를 모드 연산을 통해 줄여줄 수 있다.
이후 R번 회전 시켰을 때 시작 칸에 어떤 결과 값이 오는지를 특정 지은 후 해당 칸에 맞춰서 돌리면서 복제 배열을 업데이트 해주면 된다.
N x N 배열이 주어진다고 가정했을 때 최악의 경우에도 (N / 2)개의 회전해야 하는 사각형 개수, 해당 배열이 각 배열의 크기만큼 돈다고 해도 계산 과정은 하나의 사각형을 전부 3번 돌면 끝난다.
결국 O(N^2)의 최악의 시간복잡도가 주어지겠지만 N x N = 300 * 300이 최대이므로 전부 계산한다해도 1초 안에 해결이 가능할 것이라고 생각했다. 
*/

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
	
	// 오리지널과 복사본을 차례대로 돌려가면서 값을 복사해서 저장
	private static void rotate(int idx) {
		int rowO = idx;
		int colO = idx;
		int dO = 0;
		
		int rowD = row;
		int colD = col;
		int dd = d;
		
		for(int i = 0; i < 2 * (N- 2 * idx) + 2 * (M-2 * idx-2); i++) {
			tr = rowO + delta[dO][0];
			tc = colO + delta[dO][1];
			if (!isIn(idx)) {
				if (++dO > 3) {
					dO = 0;
				}
				tr = rowO + delta[dO][0];
				tc = colO + delta[dO][1];
			}
			rowO = tr;
			colO = tc;
			
			tr = rowD + delta[dd][0];
			tc = colD + delta[dd][1];
			if (!isIn(idx)) {
				if (++dd > 3) {
					dd = 0;
				}
				tr = rowD + delta[dd][0];
				tc = colD + delta[dd][1];
			}
			rowD = tr;
			colD = tc;
			duplicate[rowD][colD] = original[rowO][colO]; 
		}
	}
	
	// 한 사각형을 구해준 횟수만큼 돌렸을 때 첫번째 칸이 어느 칸에 가 있는지를 확인 
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
	
	// 전형적인 isIn 함수
	private static boolean isIn(int idx) {
		if (tr >= idx && tr < N-idx && tc >= idx && tc < M-idx) {
			return true;
		} else {
			return false;
		}
	}
}
