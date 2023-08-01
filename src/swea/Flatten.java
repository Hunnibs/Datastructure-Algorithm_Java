package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Flatten {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int dump = Integer.parseInt(st.nextToken());
			arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			
			int answer = arr[99] - arr[0];
			sb.append("#" + test_case + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}
}
