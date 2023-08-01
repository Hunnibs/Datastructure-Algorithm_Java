package boj.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int M = 1234567891;
    static int N;
    static String words;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        words = st.nextToken();

        long sum = 0;
        long pow = 1;
        for(int i =0; i< N; i++){
            sum += ((words.charAt(i) - 'a' + 1) * pow % M);
            pow = pow * 31 % M;
        }
        System.out.println(sum % M);
    }
}
