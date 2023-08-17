package boj.bronze2;

/**

@author 이병헌
@since 2023. 8. 11.
@see https://www.acmicpc.net/problem/3040
@git
@youtube
@performance O(2 ^ N)
@category # Combination
@note 
9C7을 돌아보면서 합이 100이 되는 경우 출력해주면 되는 간단한 문제
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_03040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] shorts = new int[9];
	static int[] answer = new int[7];
	static int sum = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			shorts[i] = Integer.parseInt(br.readLine());
		}
		
		//main
		combination(0, 0, 0);
		System.out.println(sb);
	}
	
	private static void combination(int start, int depth, int sum) {
		if (depth == 7) {
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(answer[i]).append("\n");
				}
			}
			return;
		} else {
			for (int i = start; i < 9; i++) {
				answer[depth] = shorts[i];
				combination(i+1, depth+1, sum + shorts[i]);
			}
		}
	}
}
