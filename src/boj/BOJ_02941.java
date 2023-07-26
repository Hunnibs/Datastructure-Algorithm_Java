package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02941 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String[] croAlpha = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
		
		st = new StringTokenizer(br.readLine());
		String words = st.nextToken();
		
		int idx = 0;
		int answer = 0;
		while(idx < words.length()) {
			if (idx+1 == words.length()) {
				answer++;
				break;
			}
			
			String sub = words.substring(idx, idx+2);
			int flag = 0;
			for(int i = 0; i < 7; i++) {
				if (sub.equals(croAlpha[i])) {
					idx += 2;
					answer++;
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				continue;
			}
			
			if(idx+2 == words.length()) {
				answer += 2;
				break;
			}
			if(words.substring(idx, idx+3).equals("dz=")) {
				idx += 3;
				answer++;
				continue;
			}
			idx++;
			answer++;
		}
		System.out.println(answer);
	}	
}
