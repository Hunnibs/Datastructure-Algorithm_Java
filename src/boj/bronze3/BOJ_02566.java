package boj.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02566 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		int row = 0, col = 0, max = Integer.MIN_VALUE;
		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				int tmp = Integer.parseInt(st.nextToken());
				max = Math.max(tmp, max);
				if (max == tmp) {
					row = r+1;
					col = c+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
	}
}
