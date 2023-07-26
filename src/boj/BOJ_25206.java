package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		double scoreSum = 0;
		double classSum = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String class2 = st.nextToken();
			
			classSum += score;
			switch(class2) {
				case "A+":
					scoreSum += (score * 4.5);
					break;
				case "A0":
					scoreSum += (score * 4.0);
					break;
				case "B+":
					scoreSum += (score * 3.5);
					break;
				case "B0":
					scoreSum += (score * 3.0);
					break;
				case "C+":
					scoreSum += (score * 2.5);
					break;
				case "C0":
					scoreSum += (score * 2.0);
					break;
				case "D+":
					scoreSum += (score * 1.5);
					break;
				case "D0":
					scoreSum += (score * 1.0);
					break;
				case "F":
					scoreSum += 0.0;
					break;
				case "P":
					classSum -= score;
					break;
			}
		}
		System.out.println(scoreSum / classSum);
	}
}
