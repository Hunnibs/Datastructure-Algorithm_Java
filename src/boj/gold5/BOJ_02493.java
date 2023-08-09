package boj.gold5;

/**

@author 이병헌
@since 2023. 8. 7.
@see https://www.acmicpc.net/problem/2493
@git
@youtube
@performance O(2N)
@category # Stack
@note 
뒤에서부터 높이 정보와 현재 인덱스 정보를 Stack에 저장해주고
다음 타워가 올때마다 비교해서 현재 타워 높이보다 크다면 Stack에서 빼주면서 부딪힌 타워 인덱스로 업데이트 해준다.
stack 내의 원소들에 대해서는 매번 모두 탐색을 해주어야한다. 

즉, 나보다 높은 타워를 만나야지만 업데이트 해준다

탐색 시 스택에서의 연산은 새로 들어온 타워의 높이가 더 크지 않으면 시작하지 않고 더 크다면 스택 내의 연산을 하면서 pop으로 없애주므로 최악의 경우 2 * N 번의 연산만으로 가능할 것이다. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;



public class BOJ_02493 {
	static class Info{
		int index, value;

		public Info(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
    	
    	//input
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	
    	int[] tower = new int[N];
    	int[] answer = new int[N];
    	Deque<Info> dq = new ArrayDeque<>();
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		tower[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// main
    	for (int i = N-1; i >= 0; i--) {
    		if (dq.isEmpty()) {
    			dq.offer(new Info(i, tower[i]));
    		} else {
    			while(dq.peekLast().value < tower[i]) {
	    			answer[dq.pollLast().index] = i+1;
	    			if(dq.isEmpty()) {
	    				break;
	    			}
    			}

				dq.offer(new Info(i, tower[i]));
    		}
    	}

    	// output
    	for (int i = 0; i < answer.length; i++) {
    		sb.append(answer[i]).append(" ");
    	}
    	System.out.println(sb);
	}

}
