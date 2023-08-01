package boj.bronze2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_01152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        StringTokenizer st = new StringTokenizer(word, " ");
        System.out.println(st.countTokens());
    }
}
