/**

@author 이병헌
@since 2023. 8. 11.
@see https://www.acmicpc.net/problem/15686
@git
@youtube
@performance 
@category #
@note 
치킨 집 중에서 M개만 남기고 폐업시켜야하므로 남길 수 있는 치킨 집 좌표의 조합을 구해준다. 이 후 조합마다 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Info{
		int row, col;

		public Info(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		@Override
			public String toString() {
				// TODO Auo-generated method stub
				return "[" + row + " " + col + "]"; 

			}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, loc, sum, min, answer;
	static Boolean[] visited;
	static ArrayList<Info> house = new ArrayList<Info>();
	static ArrayList<Info> chickenHouse = new ArrayList<Info>();
	static ArrayList<Info> comb = new ArrayList<Info>();
	static ArrayList<ArrayList<Info>> remainChickenHouse = new ArrayList<ArrayList<Info>>();
	
	public static void main(String[] args) throws IOException{
		// input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				loc = Integer.parseInt(st.nextToken());
				if (loc == 1) {
					house.add(new Info(r, c));
				} else if (loc == 2) {
					chickenHouse.add(new Info(r, c));
				} 
			}
		}

		// main
		// Combination을 이용해서 남은 치킨집 배열 생성
		combination(0, 0);

		// 남은 치킨집과 거리 비교로 최소 거리 측정
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < remainChickenHouse.size(); i++) {
			chickenDistance(i);
		}
		
		// 출력
		System.out.println(answer);
	}
	
	static void combination(int start, int depth) {
		if (depth == M) {
			ArrayList<Info> tmp = new ArrayList<>(comb);
			remainChickenHouse.add(tmp);	
		}
		
		for (int i = start; i < chickenHouse.size(); i++) {
			comb.add(new Info(chickenHouse.get(i).row, chickenHouse.get(i).col));
			combination(i+1, depth+1);
			comb.remove(comb.size()-1);
		}
	}
	
	static void chickenDistance(int x) {
		ArrayList<Info> tmp = remainChickenHouse.get(x);
		sum = 0;
		for (int i = 0; i < house.size(); i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < tmp.size(); j++) {
				min = Math.min(min, Math.abs(house.get(i).row - tmp.get(j).row) + Math.abs(house.get(i).col - tmp.get(j).col));
			}
			sum += min;
		}
		answer = Math.min(answer, sum);
	}
}