package boj.sprouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05597 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] students = new int[30];
		
		for(int i = 0; i < 28; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			students[num-1]++;
		}
		
		for(int i = 0; i < 30; i++) {
			if(students[i] ==0) {
				System.out.println(i+1);
			}
		}
	}

}
