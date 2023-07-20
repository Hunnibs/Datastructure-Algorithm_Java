package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_01157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[27];

        String word = sc.next();

        word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i)-65;
            alphabet[num] += 1;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < alphabet.length; i++) {
            max = Math.max(alphabet[i], max);
            if (max == alphabet[i]){
                idx = i;
            }
        }

        Arrays.sort(alphabet);
        if (alphabet[alphabet.length-1] == alphabet[alphabet.length-2]){
            System.out.println("?");
        }else {
            System.out.println((char)(idx+65));
        }
    }
}
