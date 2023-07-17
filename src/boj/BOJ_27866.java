package boj;

import java.util.Scanner;

public class BOJ_27866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		int N = sc.nextInt();
		String[] arr = new String[name.length()];
		
		for (int i = 0; i < name.length(); i++) {
			arr[i] = Character.toString(name.charAt(i));
		}
		
		System.out.println(arr[N-1]);
	}

}
