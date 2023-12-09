package boj.bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02744 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       
       String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else{
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }

        System.out.println(sb);
    }
}
