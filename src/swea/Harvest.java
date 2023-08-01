package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 1.
@see
@git
@youtube
@performance O(N ^ 2)
@category # Implementation
@note 
		
*/

public class Harvest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[] s;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] farm;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= test; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				s = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s[j] - '0';
				}
			}
			
			int sum = 0;
			int cnt = 0;
			int mid = N / 2;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (c >= mid-cnt && c <= mid+cnt) {
						sum += farm[r][c];
					}
				}
				if (mid <= r) {
					cnt--;
				} else {
					cnt++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
