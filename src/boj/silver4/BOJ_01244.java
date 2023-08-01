package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, m, gender, num, tl, tr;
	static int[] button;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		button = new int[n];
		for (int i= 0; i < n; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				man();
			} else {
				woman();
			}

		}
		for(int i =0; i < n; i++) {
			if (i != 0 && i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(button[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static void man() {
		for (int i = 0; i < n; i++) {
			if ((i+1) % num == 0) {
				if (button[i] == 0) {
					button[i] = 1;
				} else {
					button[i] = 0;
				}
			}
		}
	}
	
	static void woman() {
		num -= 1;
		int cnt = 1;
		while (true) {
			tl = num - cnt;
			tr = num + cnt;
			if(isIn()) {
				if (button[tl] == button[tr]) {
					if (button[tl] == 0) {
						button[tl] = 1;
					} else {
						button[tl] = 0;
					}
					
					if (button[tr] == 0) {
						button[tr] = 1;
					} else {
						button[tr] = 0;
					}
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		
		if (button[num] == 0) {
			button[num] = 1;
		} else {
			button[num] = 0;
		}
		
	}
	
	static boolean isIn() {
		if (tl >= 0 && tl < n && tr >= 0 && tr < n) {
			return true;
		} else {
			return false;
		}
	}

}
