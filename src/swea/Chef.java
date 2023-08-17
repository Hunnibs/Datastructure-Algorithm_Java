package swea;
/**

@author 이병헌
@since 2023. 8. 10.
@see
@git
@youtube
@performance
@category # Combination
@note 
조합으로 N개 중 N/2개를 뽑는 경우를 탐색한다. 
이 때, 탐색을 위해서 visited 배열을 만들고 뽑는 경우는 1로 업데이트 해준다.(비트 연산 방식과 동일)
기저 조건에 도달한다면 해당 배열을 이용해 두 개의 조합으로 나눌 수 있다 뽑힌 것과 안 뽑힌 것
두 조합을 구할 수 있다면 두 조합에서 나올 수 있는 시너지를 구하고  answer값에 계속해서 min인 값을 업데이트 해주면 된다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chef {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] ingredient;
	static boolean[] visited;
	static ArrayList<Integer> comb1, comb2;
	static int N, R, answer, sum;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {																																																																																																																												
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			sum = 0;
			answer = Integer.MAX_VALUE;
			visited = new boolean[N];
			ingredient = new int[N][N];
			comb1 = new ArrayList<>();
			comb2 = new ArrayList<>();
			
			for(int r =0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c =0; c < N; c++) {
					ingredient[r][c] = Integer.parseInt(st.nextToken());
					sum += ingredient[r][c];
				}
			}
			
			combination(0, 0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void combination(int start, int depth) {
																		
		if (depth == R) {
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					comb1.add(i);
				} else {
					comb2.add(i);
				}
			}

			int sum1 =0, sum2 =0;
			for (int i = 0; i < R; i++) {
				for (int j =0; j < R; j++) {
					if (i == j) {
						continue;
					} else {
						sum1 += ingredient[comb1.get(i)][comb1.get(j)];
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j =0; j < R; j++) {
					if (i == j) {
						continue;
					} else {
						sum2 += ingredient[comb2.get(i)][comb2.get(j)];
					}
				}
			}
			comb1.clear();
			comb2.clear();
			answer = Math.min(answer, Math.abs(sum2-sum1));
			return;
		} else {
			for (int i = start; i < N; i++) {
				visited[i] = true;
				combination(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}
