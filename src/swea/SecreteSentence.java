package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SecreteSentence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static String answer;
	static ArrayList<Integer> bundle;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for (int test_case = 1; test_case <= 10; test_case++) {
			int index, nums, token;
			
			int N = Integer.parseInt(br.readLine());
			
			bundle = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				bundle.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String command = st.nextToken();
				switch(command) {
					case "I":
						index = Integer.parseInt(st.nextToken());
						nums = Integer.parseInt(st.nextToken());
						for (int i = 0; i < nums; i++) {
							bundle.add(index+i, Integer.parseInt(st.nextToken()));
						}
						break;
					case "D":
						index = Integer.parseInt(st.nextToken());
						nums = Integer.parseInt(st.nextToken());
						for (int i = 0; i < nums; i++) {
							bundle.remove(index);
						}
						break;
					case "A":
						nums = Integer.parseInt(st.nextToken());
						for (int i = 0; i < nums; i++) {
							bundle.add(Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(bundle.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
