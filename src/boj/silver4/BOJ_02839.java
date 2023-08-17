package boj.silver4;
	
/**

@author 이병헌
@since 2023. 8. 11.
@see https://www.acmicpc.net/problem/2839
@git
@youtube
@performance 
@category # Implemetation
@note 
5KG으로 최대로 뽑을 수 있는 경우에서 3KG 최대로 뽑아 정해진 무게를 맞춰준다.
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class BOJ_02839 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int answer = -1;
		for (int i = N / 5; i >= 0; i--) {
			if ((N - (i * 5)) % 3 == 0) {
				answer = i + ((N - (i * 5)) / 3); 
				break;
			}
		}
		System.out.println(answer);
	}
}
