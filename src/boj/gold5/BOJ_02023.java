package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 본인이름
@since 2023. 8. 4.
@see https://www.acmicpc.net/problem/2023
@git
@youtube
@performance
@category # implementation
@note 
메모리 4MB 제한으로 에라토스테네스의 체를 사용할 수는 없다. 
배열로 한 자리수에서 가능한 경우를 설정하고 그 때만 탐색을 시작한다.
*/

public class BOJ_02023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, answer, flag;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int[] prime = {2, 3, 5, 7};
		
		int idx = 0;
		for (int i = 1; i < 10; i++) {
			if (idx == 4) {
				break;
			}
			
			if (prime[idx] == i) {
				idx++;
				isPrime(i * 10, 1);
			}
		}
	}
	
	private static void isPrime(int num, int cnt) {
		if (cnt == N) {
			System.out.println(num / 10);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			num += i;
			flag = 0;
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				isPrime(num * 10, cnt+1);
			}
			num -= i;
		}
	}
}
