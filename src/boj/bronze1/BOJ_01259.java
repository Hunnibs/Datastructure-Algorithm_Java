package boj.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01259 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        while (!num.equals("0")){
            String answer = "yes";
            for(int i = 0; i < num.length() / 2; i++){
                if (num.charAt(i) != num.charAt(num.length()-1-i)){
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);

            st = new StringTokenizer(br.readLine());
            num = st.nextToken();
        }
    }
}
