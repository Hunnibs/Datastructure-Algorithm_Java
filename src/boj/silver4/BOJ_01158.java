package boj.silver4;

/**

@author 이병헌
@since 2023. 8. 7.
@see https://www.acmicpc.net/problem/1158
@git
@youtube
@performance O(
@category # 연결리스트
@note */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> people = new ArrayList<>();
		for (int i = 0 ; i < N; i++) {
			people.add(i+1);
		}
		
		int[] answer = new int[N];
		int cnt = K-1;
		int idx = 0;
		while (!people.isEmpty()) {
			if (cnt >= people.size()) {
				cnt = cnt % people.size();
			}
			answer[idx++] = people.get(cnt);
			people.remove(cnt);
			cnt += K-1;
		}

		sb.append("<");
		for (int i = 0; i < N; i++) {
			if (i == N-1) {
				sb.append(answer[i]);
			} else {
				sb.append(answer[i] + ", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
	
}
