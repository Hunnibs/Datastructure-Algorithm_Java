package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**

@author 이병헌
@since 2023. 8. 17.
@see
@git
@youtube
@performance
@category #
@note 
정상 방법으로는 정렬할 수 없어 수를 넣자마자 정렬을 시행하는 tree set을 활용 -> 문제의 조건에 중복되는 수를 넣어주지 않는다고 적혀있다. 
*/

public class BOJ_02751 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> tree = new TreeSet<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			tree.add(Integer.parseInt(br.readLine()));
		}
		
		Iterator iter = tree.iterator();	// Iterator 사용
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb);
	}
}
