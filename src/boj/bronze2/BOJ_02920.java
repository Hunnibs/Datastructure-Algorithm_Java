package boj.bronze2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_02920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i<8; i++) {
			arr.add(sc.nextInt());
		}
		ArrayList<Integer> arrSort = (ArrayList<Integer>) arr.clone();
		Collections.sort(arrSort);
		
		ArrayList<Integer> arrReverseSort = (ArrayList<Integer>) arr.clone();
		Collections.sort(arrReverseSort, Collections.reverseOrder());
		
		if (arrSort.equals(arr)) {
			System.out.println("ascending");
		} else if (arrReverseSort.equals(arr)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
	
}
