package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 이병헌	
@since 2023. 8. 10.
@see https://swexpertacademy.com/main/talk/solvingClub/problemPassedUser.do?contestProbId=AWgv9va6HnkDFAW0&solveclubId=AYlH3z4K78kDFAVR&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=7&probBoxId=AYnN7JhqMPoDFAUe
@git
@youtube
@performance 
@category # Next Permutation # Brute Force
@note 
Next Permutation을 이용해 인영이의 카드 조합을 구하고 해당 카드 조합과 고정된 규영이의 카드 조합을 비교해서 승패를 가른다. 
*/

public class CardGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] guyoung, inyoung;
	static int win , lose ;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int[] card = new int[19];
			inyoung = new int[9];
			guyoung = new int[9];
			for (int i = 0; i < 9; i++) {
				guyoung[i] = Integer.parseInt(st.nextToken());
				card[guyoung[i]] = 1;
			}	
			
			win = 0;
			lose = 0;
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (card[i] == 0) {
					inyoung[idx++] = i;
				}
			}
			
			do {
				compare();
			}while(np());
			
			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean np() {  // p: 다음 순열을 만들기 원하는 기존 순열의 배열
		// 1. 
		int lastPeak = 9-1;
		while(lastPeak > 0 && inyoung[lastPeak-1] >= inyoung[lastPeak]) {
			lastPeak--;
		}
		if (lastPeak == 0) {
			return false;
		}
		
		// 2.
		int nextBoss = 9-1;
		while(inyoung[lastPeak-1] >= inyoung[nextBoss]) {
			nextBoss--;
		}
		
		// 3. 
		swap(inyoung, nextBoss, lastPeak-1);
		
		// 4. 
		for (int left = lastPeak, right = 9-1; left < right; left++, right--) {
			swap(inyoung, left, right);
		}
		return true;
	}
	
	private static void compare() {
		int sumG = 0, sumI = 0;
		for (int i =0; i < 9; i++) {
			if (guyoung[i] > inyoung[i]) {
				sumG += (guyoung[i] + inyoung[i]);
			} else if(guyoung[i] < inyoung[i]) {
				sumI += (guyoung[i] + inyoung[i]);
			}
		}
		if (sumG > sumI) {
			win++;
		} else if (sumG < sumI) {
			lose++;
		}
	}
	
	private static void swap(int[] p, int a, int b) {
		// TODO Auto-generated method stub
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
}
