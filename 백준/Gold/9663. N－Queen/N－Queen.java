import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, answer = 0;
	static int[] col;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		
		col = new int[N+1];
		setQueen(1);
		System.out.println(answer);
	}

	// 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {
		if (!isAvailable(row-1)) {
			return;
		}
		
		if (row > N) {
			answer++;
			return;
		}
		
		for (int c = 1; c <= N; c++) {
			col[row] = c;
			setQueen(row+1);
		}
	}
	
	private static boolean isAvailable(int row) {
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row] || Math.abs(col[row] - col[i]) == row - i) {
				return false;
			}
		}
		return true;
	}
}