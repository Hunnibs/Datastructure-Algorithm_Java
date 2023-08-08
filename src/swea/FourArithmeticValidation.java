package swea;

/**

@author 이병헌
@since 2023. 8. 8.
@see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
@git
@youtube
@performance
@category # Binary Tree # Array
@note 
입력이 짝수인 경우는 애초에 연산이 안되는 경우
홀수일 때는 -2씩 해주면서 현재 idx / 2에 연산자를 이용해서 결과 업데이트
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourArithmeticValidation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String[] binaryTree;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			binaryTree = new String[N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				binaryTree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			
			int answer = 1;
			if (N % 2 == 0) {
				answer = 0;
			} else {
				for (int idx = N-1; idx > 0; idx -= 2) {
					if(isValid(idx)) {
						String tmp = binaryTree[idx / 2];
						int a = Integer.parseInt(binaryTree[idx]);
						int b = Integer.parseInt(binaryTree[idx+1]);
						switch(tmp) {
						case "+":
							binaryTree[idx / 2] = String.valueOf(a + b);
							break;
						case "-":
							binaryTree[idx / 2] = String.valueOf(a - b);
							break;
						case "*":
							binaryTree[idx / 2] = String.valueOf(a * b);
							break;
						case "/":
							if (b == 0) {
								b++;
							}
							binaryTree[idx / 2] = String.valueOf(a / b);
							break;
						}
					} else {
						answer = 0;
						break;
					}
				}
			}
			System.out.println(binaryTree[1]);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isValid(int idx) {
		String tmp = binaryTree[idx / 2];
		String a = binaryTree[idx];
		String b = binaryTree[idx+1];
		if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
			if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {
				return false;
			} else if(b.equals("+") || b.equals("-") || b.equals("*") || b.equals("/")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
