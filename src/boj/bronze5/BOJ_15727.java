package boj.bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 5; i > 0; i--) {
            if (L / i >= 1){
                int tmp = L / i;
                answer += tmp;
                L %= i;
            }
        }

        System.out.println(answer);
    }
}
