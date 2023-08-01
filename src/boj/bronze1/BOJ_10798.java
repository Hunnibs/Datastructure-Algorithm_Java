package boj.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10798 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		char[][] arr = new char[5][15];
		for (int i = 0; i < 5; i++) {
			Arrays.fill(arr[i], '=');
		}
		
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			for (int c = 0; c < word.length(); c++) {
				arr[r][c] = word.charAt(c);
			}
		}

		for(int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {
				if(arr[r][c] == '=') {
					
				}else {
					System.out.print(arr[r][c]);
				}
			}
		}
		
	}

}
