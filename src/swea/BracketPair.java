package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**

@author 본인이름
@since 2023. 8. 4.
@see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
@git
@youtube
@performance
@category # 스택
@note 
시간은 20초 메모리는 256MB
스택 배열을 하나 만들고 좌측 괄호만 탐색하면서 저장 -> 페어가 되는 우측 괄호가 오면 pop 
이 때, 우측 배열이 왔는데 pair가 아니라면 0을 출력

++ 기존 코드는 열린 괄호만 주어졌을 때도 해당 테스트를 통과할 수 있는 허점이 있다. 
그래서 check 함수를 추가해줬다.
*/

public class BracketPair {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] condition; 
	static int N, answer;
	static char[] bracket;
	static Deque<Character> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String S = br.readLine();
			bracket = S.toCharArray();
			condition = new int[]{0, 0, 0, 0};
			if (check()) {
				char tmp;
				answer = 1;
				for (int i = 0; i < bracket.length; i++) {
					tmp = bracket[i];
					switch(tmp) {
						case '(':
						case '{':
						case '[':
						case '<':
							stack.offer(tmp);
							break;
						case ')':
							if (stack.isEmpty()) {
								answer = 0;
								break;
							} else {
								if (stack.pollLast() == '(') {
									break;
								} else {
									answer = 0;
									break;
								}
							}
						case '}':
							if (stack.isEmpty()) {
								answer = 0;
								break;
							} else {
								if (stack.pollLast() == '{') {
									break;
								} else {
									answer = 0;
									break;
								}
							}
						case ']':
							if (stack.isEmpty()) {
								answer = 0;
								break;
							} else {
								if (stack.pollLast() == '[') {
									break;
								} else {
									answer = 0;
									break;
								}
							}
						case '>':
							if (stack.isEmpty()) {
								answer = 0;
								break;
							} else {
								if (stack.pollLast() == '<') {
									break;
								} else {
									answer = 0;
									break;
								}
							}
					}
					if (answer == 0) {
						break;
					}
				}
			} else {
				answer = 0;
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean check() {
		for (int i= 0; i < bracket.length; i++) {
			char tmp = bracket[i];
			switch(tmp) {
				case '(':
					condition[0]++;
					break;
				case '{':
					condition[1]++;
					break;
				case '[':
					condition[2]++;
					break;
				case '<':
					condition[3]++;
					break;
				case ')':
					condition[0]--;
					break;
				case '}':
					condition[1]--;
					break;
				case ']':
					condition[2]--;
					break;
				case '>':
					condition[3]--;
					break;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if(condition[i] != 0) {
				return false;
			} 
		}
		return true;
	}
}
