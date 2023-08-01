package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01316 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static String word;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for(int test_case = 1; test_case <= N; test_case++) {
			int[] arr = new int[27];
			st = new StringTokenizer(br.readLine());
			word = st.nextToken();
			
			char tmp = '0';
			int flag = 0;
			for(int i = 0; i < word.length(); i++) {
				char alpha = word.charAt(i);
				if (tmp == alpha) {
					 continue;
				} else {
					tmp = alpha;
					if (arr[alpha - 'a'] == 0) {
						arr[alpha - 'a']++;
					} else {
						flag = 1;
						break;
					}
				}
			}
			
			if (flag == 0) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}

}
