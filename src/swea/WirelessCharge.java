package swea;

/**

@author 이병헌
@since 2023. 8. 17.
@see
@git
@youtube
@performance
@category # 
@note 

*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WirelessCharge {
	static class Info{  // 이용 가능한 충전소 정보를 저장해줄 예정
		int idx, p;

		public Info(int idx, int p) {
			super();
			this.idx = idx;
			this.p = p;
		}	
	}
	
	static class BcInfo{  // 충전소 전체 정보를 저장해줄 예정
		int x, y, c, p;

		public BcInfo(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] delta = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int M, N; // 이동시간: M, 배터리 개수 N
	static int[] A, B;  // 이동경로 user A, B
	static int xA, yA, xB, yB;  // A, B 이동 좌표
	static int answer;  // 정답
	static ArrayList<BcInfo> bcInfos;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			// A, B 이동경로 배열에 저장
			A = new int[M+1];
			B = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC info 저장
			bcInfos = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				bcInfos.add(new BcInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			
			
			// main
			// 출발 지점 설정
			answer = 0;
			
			xA = 1;
			yA = 1;
			xB = 10;
			yB = 10;
			
			for (int i = 0; i <= M; i++) {
				// 시간에 따른 위치 업데이트
				// x, y 좌표가 일반적인 row, col으로 주어지는 좌표와 반대이므로 처음부터 거꾸로 받아준다. 
				yA += delta[A[i]][0];
				xA += delta[A[i]][1];
				yB += delta[B[i]][0];
				xB += delta[B[i]][1];
				
				// 충전 가능한 것 중 가장 최고의 효율로 충전 진행
				searchCharge();
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void searchCharge() {
		ArrayList<Info> infoA = new ArrayList<>();  // A에서 이용가능한 충전소 정보 저장
		ArrayList<Info> infoB = new ArrayList<>();  // B에서 이용가능한 충전소 정보 저장
		
		int x, y, c, p;
		for (int i = 0; i < N; i++) {
			x = bcInfos.get(i).x;
			y = bcInfos.get(i).y;
			c = bcInfos.get(i).c;
			p = bcInfos.get(i).p;
			
			if (distance(xA, yA, x, y) <= c) {
				infoA.add(new Info(i, p));
			}
			if (distance(xB, yB, x, y) <= c) {
				infoB.add(new Info(i, p));
			}
		}
		
		// 충전 가능한 경우끼리 전부 비교해보면서 최고의 효율을 추가
		int sum = Integer.MIN_VALUE;
		
		if (infoA.isEmpty() && infoB.isEmpty()) {  // 모두 비어있을 경우 충전 가능한 것이 없다.
			return;
		} else if (infoB.isEmpty()) {  // B만 비어있을 경우
			for (int i = 0; i < infoA.size(); i++) {
				sum = Math.max(sum, infoA.get(i).p);
			}
		} else if (infoA.isEmpty()) {  // A만 비어있을 경우
			for (int i = 0; i < infoB.size(); i++) {
				sum = Math.max(sum, infoB.get(i).p);
			}
		} else {  // 둘다 충전 가능한 것이 있을 경우
			for (int i = 0; i < infoA.size(); i++) {
				for (int j = 0; j < infoB.size(); j++) {
					if (infoA.get(i).idx == infoB.get(j).idx) {
						sum = Math.max(sum, infoA.get(i).p);
					} else {
						sum = Math.max(sum, infoA.get(i).p + infoB.get(j).p);
					}
				}
			}
		}
		answer += sum;
	}
	
	private static int distance(int r1, int c1, int r2, int c2) {  // 충전 가능 범위 계산
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}
