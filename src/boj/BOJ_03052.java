package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03052 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] remainder = new int[42];
		
		for (int i =0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			remainder[Integer.parseInt(st.nextToken()) % 42] = 1;
		}
		
		int cnt = 0;
		for (int i =0; i<42; i++) {
			if(remainder[i] == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
