package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, loc, sum, min, answer;
	static Boolean[] visited;
	static ArrayList<ArrayList<Integer>> house = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> chickenHouse = new ArrayList<>();
	static ArrayList<ArrayList<ArrayList<Integer>>> remainChickenHouse = new ArrayList<>();
	static ArrayList<Integer> sums = new ArrayList<>();
	static ArrayList<Integer> tmp;
	static ArrayList<ArrayList<Integer>> tmp3 = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				tmp = new ArrayList<>();
				loc = Integer.parseInt(st.nextToken());
				tmp.add(r);
				tmp.add(c);
				if (loc == 1) {
					house.add(tmp);
				} else if (loc == 2) {
					chickenHouse.add(tmp);
				} 
			}
		}

		// main
		// Combination을 이용해서 남은 치킨집 배열 생성
		ArrayList<ArrayList<Integer>> tmp2 = new ArrayList<>();
		visited = new Boolean[chickenHouse.size()];
		combination(tmp2, 0, chickenHouse.size(), M);
		// 남은 치킨집과 거리 비교로 최소 거리 측정
		for (int i = 0; i < remainChickenHouse.size(); i++) {
			chickenDistance(i);
		}
		
		// 출력
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < sums.size(); i++) {
			answer = Math.min(answer, sums.get(i)); 
		}
		System.out.println(answer);
	}
	
	static void combination(ArrayList<ArrayList<Integer>> tmp2, int start, int n, int r) {
		if (r == 0) {
			tmp3 = new ArrayList<>();
			for (int i = 0; i < tmp2.size(); i++) {
				tmp3.add(tmp2.get(i));
			}
			remainChickenHouse.add(tmp3);
		}
		
		for (int i = start; i < n; i++) {
			visited[i] = true;
			tmp2.add(chickenHouse.get(i));
			combination(tmp2, i+1, n, r-1);
			tmp2.remove(tmp2.size()-1);
			visited[i] = false;
		}
	}
	
	static void chickenDistance(int x) {
		tmp3 = new ArrayList<>();
		tmp3 = remainChickenHouse.get(x);
		sum = 0;
		for (int i = 0; i < house.size(); i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < tmp3.size(); j++) {
				min = Math.min(min, Math.abs(house.get(i).get(0) - tmp3.get(j).get(0)) + Math.abs(house.get(i).get(1) - tmp3.get(j).get(1)));
			}
			sum += min;
		}
		
		sums.add(sum);
	}
}
