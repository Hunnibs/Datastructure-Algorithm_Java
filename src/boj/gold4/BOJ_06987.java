package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 16.
@see https://www.acmicpc.net/problem/6987
@git
@youtube
@performance
@category # 
@note */

public class BOJ_06987 {
	static class Info{
		int win, draw, lose;

		public Info(int win, int draw, int lose) {
			super();
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}	
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Info> group;
	static ArrayList<int[]> tournament;
	static int[] versus;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {	// TODO Auto-generated method stub	
		tournament = new ArrayList<>();
		versus = new int[2];
		combination(0, 0);
		
		for (int test_case = 1; test_case <= 4; test_case++) {
			group = new ArrayList<>();
			flag = true;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());  // 비긴 횟수가 비슷하지 않으면 끝
				int lose = Integer.parseInt(st.nextToken());
				
				group.add(new Info(win, draw, lose));	
			}
		
			sol(0);
			
			if (flag) {
				sb.append(0).append(" ");
			} else {
				sb.append(1).append(" ");
			}
		}
		System.out.println(sb);
	}
	
	private static void sol(int depth) {
		if (depth == tournament.size()) {
			for (int i = 0; i < 6; i++) {
				if (group.get(i).draw != 0 || group.get(i).win != 0 || group.get(i).lose != 0) {
					return;
				}
			}
			flag = false;
			return;
		} else {
			int A = tournament.get(depth)[0];
			int B = tournament.get(depth)[1];
			
			// A팀이  B팀을 이길 경우
			if (group.get(A).win > 0 && group.get(B).lose > 0) {
				group.get(A).win--;
				group.get(B).lose--;
				sol(depth+1);
				group.get(A).win++;
				group.get(B).lose++;
			}
			
			// B팀이 A팀을 이길 경우
			if (group.get(A).lose > 0 && group.get(B).win > 0) {
				group.get(A).lose--;
				group.get(B).win--;
				sol(depth+1);
				group.get(A).lose++;
				group.get(B).win++;
			}
			
			if (group.get(A).draw > 0 && group.get(B).draw > 0) {
				group.get(A).draw--;
				group.get(B).draw--;
				sol(depth+1);
				group.get(A).draw++;
				group.get(B).draw++;
			}
		}
	}
	
	private static void combination(int start, int depth) {
		if (depth == 2) {
			tournament.add(versus.clone());
			return;
		} else {
			for (int i = start; i < 6; i++) {
				versus[depth] = i;
				combination(i+1, depth+1);
			}
		}
	}
}
