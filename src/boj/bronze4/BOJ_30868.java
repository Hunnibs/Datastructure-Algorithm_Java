package boj.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_30868 {
    static final String line = "++++";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j = 0; j < num / 5; j++) {
                sb.append(line).append(" ");
            }

            for (int j = 0; j < num % 5; j++) {
                sb.append("|");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
