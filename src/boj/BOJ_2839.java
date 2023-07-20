	package boj;
	
	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
	public class BOJ_2839 {
	
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
