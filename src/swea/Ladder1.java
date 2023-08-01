package swea;

/**

@author 이병헌
@since 2023. 8. 1.
@see
@git
@youtube
@performance O(row * col)
@category #
@note 
	사다리의 목적지가 2로 표현되기 때문에 밑에서부터 탐색을 시작하는게 point 단 한 번의 탐색만으로 해결 가능
	결과적으로 주어진 사다리의 크기를 N이라 할 때 O(row * col)으로 해결 가능하다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, row, col, tr, tc, d;
	static int[][] ladder;
	
	static int[] deltaUp = {-1, 0};
	static int[][] delta = {{0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			ladder = new int[100][100];
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 100; c++) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
					if(r == 99 && ladder[r][c] == 2) {
						row = r;
						col = c;
					}
				}
			}
			
			while(row > 0) {
				if(checkSide()) {
					goSide();
				} 
				row += deltaUp[0];
				col += deltaUp[1];
			}
			
			sb.append("#").append(num).append(" ").append(col).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean checkSide() {
		for (int i = 0; i < 2; i++) {
			tr = row+delta[i][0];
			tc = col+delta[i][1];
			if(isIn()) {
				if(ladder[tr][tc] == 1) {
					d = i;
					row = tr;
					col = tc;
					return true;
				}
			}
		}
		return false;
	}
	
	static void goSide() {
		while (ladder[row][col] == 1) {
			tr = row + delta[d][0];
			tc = col + delta[d][1];
			if (isIn()) {
				if (ladder[tr][tc] == 0) {
					break;
				}
				row = tr;
				col = tc;
			} else {
				break;
			}
		}
	}
	
	static boolean isIn() {
		if (tr >= 0 && tr < 100 && tc >= 0 && tc < 100) {
			return true;
		} else {
			return false;
		}
	}
}
