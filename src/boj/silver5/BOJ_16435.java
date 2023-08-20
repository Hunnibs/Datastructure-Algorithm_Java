package boj.silver5;

/**

@author 이병헌
@since 2023. 8. 11.
@see https://www.acmicpc.net/problem/16435
@git
@youtube
@performance O(N^2)
@category # sort
@note 
주어진 사과의 높이를 정렬을 해서 0번 인덱스부터 차례대로 먹을 수 있는 과일은 먹어주면서 몸 길이를 늘려주다가 아무것도 먹을 수 없을 때 루프문을 탈출하고 몸길이를 출력한다.
배열의 정렬은 최악의 경우 O(N^2)으로 문제에서 주어진 1초 안에 무조건 계산이 가능하다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16435 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] apples = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i =0; i < N; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(apples);
		
		for (int i = 0; i < N; i++) {
			if (apples[i] <= L) {
				L++;
			} else {
				break;
			}
		}
		
		System.out.println(L);
	}

}
