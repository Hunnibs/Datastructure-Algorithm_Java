package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 10.
@see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYlH3z4K78kDFAVR&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AYnN7JhqMPoDFAUe&type=PROBLEM&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=7
@git
@youtube
@performance
@category # Dynamic Programming
@note 
백준 평범한 배낭 문제와 동일
*/

public class HamDiet_subset {
	static class Info{
		int t;
		int k;
		public Info(int t, int k) {
			super();
			this.t = t;
			this.k = k;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, L;
	static int answer;
	static ArrayList<Info> infos;
	static boolean[] subset;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            infos = new ArrayList<>();
            subset = new boolean[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            
            answer = Integer.MIN_VALUE;
            makeSubset(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
		System.out.println(sb);
	}
	
	private static void makeSubset(int depth, int sumT, int sumK) {
		if (sumK > L) {
			return;
		}
		
		if (depth == N) {
			answer = Math.max(answer, sumT);
			return;
		}
		
		subset[depth] = true;
		makeSubset(depth+1, sumT + infos.get(depth).t, sumK + infos.get(depth).k);
		subset[depth] = false;
		makeSubset(depth+1, sumT, sumK);
		
	}
}
