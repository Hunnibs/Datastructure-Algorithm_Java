import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, left, mid, right;
	static int[] lecture;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lecture = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			right += lecture[i];
		}
		
		// main
		while (left < right) {
			mid = (left + right) / 2;
			if(isAvailable(mid)) {
				if (sol(mid) <= M) {
					right = mid;
				} else {
					left = mid+1;
				}
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
	
	private static int sol(int size) {
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += lecture[i];
			if (sum > size) {
				cnt++;
				sum = lecture[i];
			}
		}
		cnt++;
		
		return cnt;
	}
	
	private static boolean isAvailable(int size) {  // 디스크 사이즈보다 큰 강의가 존재한다면 디스크 크기는 늘어나야한다. 
		for (int i = 0; i < N; i++) {
			if (size < lecture[i]) {
				return false;
			}
		}
		
		return true;
	}
}