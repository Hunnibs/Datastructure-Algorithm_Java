package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EditSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int answer;
	static ArrayList<Integer> sequence;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N, M, L;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			sequence = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sequence.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					String command = st.nextToken();
					switch(command) {
					case "I":
						sequence.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
						break;
					case "D":
						sequence.remove(Integer.parseInt(st.nextToken()));
						break;
					case "C":
						sequence.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
						break;
					}
				}
			}
			
			if (sequence.size() <= L) {
				answer = -1;
			} else {
				answer = sequence.get(L);
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
