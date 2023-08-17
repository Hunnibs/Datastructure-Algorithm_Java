import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 14.
@see  https://www.acmicpc.net/problem/1074
@git
@youtube
@performance
@category # 
@note */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int r, c;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(z(N)-1);
	}
	
	private static int z(int N) {
		if (N == 0) {
			if (r == 0 && c == 0) {
				return 1;
			} else if (r == 0 && c == 1) {
				return 2;
			} else if (r == 1 && c == 0) {
				return 3;
			} else {
				return 4;
			}
		}
		
		int tmp = (int) Math.pow(2, N-1);
		
		if (r < tmp && c < tmp){ // 1사분면
			return z(N-1) + (tmp * tmp * 0);
		} else if(r < tmp && c >= tmp) { // 2사분면
			c -= tmp;
			return z(N-1) + (tmp * tmp * 1);
		} else if(r >= tmp && c < tmp) { // 3사분면
			r -= tmp;
			return z(N-1) + (tmp * tmp * 2);
		} else { // 4사분면
			r -= tmp;
			c -= tmp;
			return z(N-1) + (tmp * tmp * 3);
		}
	}
}