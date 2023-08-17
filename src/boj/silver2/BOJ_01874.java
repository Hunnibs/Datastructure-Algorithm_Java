package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**

@author 이병헌
@since 2023. 08. 13
@see https://www.acmicpc.net/problem/1874
@git
@youtube
@performance
@category # Stack
@note
 오름차순으로 정렬되어 있는 수를 스택에 넣어가면서 특정 수열에 해당되면 pop, 아니면 계속 push하는 방식
 만약 해당 수열을 만들 수 없는 경우 -1을 출력하도록 해야한다.
 비교연산과 stack push, pop 연산이 전부이고 n은 2^5이므로 아무리 연산을 많이 해도 시간 N시간 안에 가능하다고 생각해 시간제한을 걱정할 필요는 없다. 메모리 또한 n의 크기로 만드는 것 치고는 넉넉하게 주어졌다.
 */

public class BOJ_01874 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        outer: for (int i = 0; i < n; i++){
            if (stack.isEmpty()){  // stack이 비어있다면 채워주고 시작
                stack.push(cnt++);
                sb.append("+").append("\n");
            }

            while(stack.peek() != nums[i]){  // stack의 peek가 원하는 순열 배열에 맞지 않다면 계속해서 push
                if (cnt > n){  // stack에 추가하는 숫자가 n값 이상이라면 만들 수 없는 순열이라는 뜻
                    sb.delete(0, sb.length());
                    sb.append("NO");
                    break outer;
                }
                stack.push(cnt++);
                sb.append("+").append("\n");
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
