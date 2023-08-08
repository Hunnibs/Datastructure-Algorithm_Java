package swea;

/**

@author 이병헌
@since 2023. 8. 8.
@see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
@git
@youtube
@performance O(N ^ 2)
@category # brute force
@note 
2개씩만 뽑아서 비교하면 되서 N x N / 2면 모든 케이스를 탐색이 가능하다. 시간은 넉넉하다고 생각해 그냥 브루트포스 방식으로 문제를 해결했다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpotMart {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//main
			int answer = Integer.MIN_VALUE;
			int tmp = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					tmp = arr[i] + arr[j];
					if (tmp <= M) {
						answer = Math.max(tmp, answer);
					}
				}
			}
			if (answer == Integer.MIN_VALUE) {
				answer = -1;
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
