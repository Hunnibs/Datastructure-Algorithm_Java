package boj.sprouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double num = 0;
        while(st.hasMoreTokens()){
            num += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        System.out.println((int)num % 10);
    }
}
