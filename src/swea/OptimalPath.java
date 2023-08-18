package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 17.
@see
@git
@youtube
@performance
@category # Brute Force # Next Permutation
@note 
고객 N명의 집을 전부 들려야 하므로 N!만큼의 경우의 수가 발생한다. 고객의 집 좌표를 받고 NP를 통해 얻은 결과에 따라 모두 방문해보면서 가장 짧은 경우를 알아낸다. 
*
*/

public class OptimalPath {
	static class Info{
		int row, col;
		
		public Info(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int TC, N, answer, r1, r2, c1, c2;
	static ArrayList<Info> infos;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TC = Integer.parseInt(br.readLine());  // test_case 개수
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());  // 고객 명수
			
			infos = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N+2; i++) { // 고객의 집 N개 + 집 + 회사 좌표를 받아서 Infos에 넣어준다. 
				infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// main
			answer = Integer.MAX_VALUE;  // 정답은 최단경로가 되어야하므로 Max_value로 설정
			
			int[] p = new int[N];  // nextpermutation을 위한 배열 생성
			for (int i = 1; i <= N; i++) {  // 방문할 순서대로 P 배열을 오름차순으로 우선 정렬
				p[i-1] = i;
			}
			
			do {
				int sum = 0;
				// 시작 지점은 회사 위치부터 출발하도록 설정
				r1 = infos.get(0).row; 
				c1 = infos.get(0).col;
				r2 = infos.get(p[0]+1).row;
				c2 = infos.get(p[0]+1).col;
				sum += distance(r1, c1, r2, c2);
				
				// 고객의 집 순서대로 순회 
				for (int i = 0; i < N - 1; i++) {  
					r1 = infos.get(p[i]+1).row;
					c1 = infos.get(p[i]+1).col; 
					r2 = infos.get(p[i+1]+1).row; 
					c2 = infos.get(p[i+1]+1).col;  
					sum += distance(r1, c1, r2, c2);
				}
				
				// 종료 지점은 집으로 
				r1 = infos.get(p[N-1]+1).row;
				c1 = infos.get(p[N-1]+1).col; 
				r2 = infos.get(1).row; 
				c2 = infos.get(1).col;  
				sum += distance(r1, c1, r2, c2);
				
				answer = Math.min(answer, sum);
			} while (np(p));
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean np(int[] p) {
		int n = p.length;
		int i = n-1;
		// 1. 맨 뒤 쪽부터 가장 큰 수 찾기
		while (i > 0 && p[i-1] >= p[i]) {
			i--;
		}
		
		if(i == 0) {  // 더 이상 탐색할 순열이 없을 경우
			return false;
		}
		
		// 2. 꼭대기 직전 위치 교환할 한 단계 큰 수 찾기
		int j = n-1;
		while(p[i-1] >= p[j]) {
			j--;
		}
		
		// 3. 꼭대기 직전 위치 수와 한 단계 큰 수 교환
		swap(p, i-1, j);
		
		// 4. 꼭대기부터 맨 뒤까지의 수를 오름차순의 형태로
		int k = n-1;
		while (i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	private static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
