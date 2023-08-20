package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 14.
@see  https://www.acmicpc.net/problem/1074
@git
@youtube
@performance
@category # Math
@note 
사분면 당 어느 지점에 있는지를 탐색해서 2 * 2 사각형이 나올때까지를 반복한다. 
*/

public class BOJ_01074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int r, c;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(z(N));
	}
	
	private static int z(int N) {
		if (N == 0) {
			if (r == 0 && c == 0) {
				return 0;
			} else if (r == 0 && c == 1) {
				return 1;
			} else if (r == 1 && c == 0) {
				return 2;
			} else {
				return 3;
			}
		}
		
		int half = (int) Math.pow(2, N-1);
		
		if (r < half && c < half){ // 1사분면
			return z(N-1) + (half * half * 0);
		} else if(r < half && c >= half) { // 2사분면
			c -= half;
			return z(N-1) + (half * half * 1);
		} else if(r >= half && c < half) { // 3사분면
			r -= half;
			return z(N-1) + (half * half * 2);
		} else { // 4사분면
			r -= half;
			c -= half;
			return z(N-1) + (half * half * 3);
		}
	}
}
