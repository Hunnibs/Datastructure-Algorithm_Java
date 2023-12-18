package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] answer = new int[m];
        combination(answer, 1, 0, n, m);
        System.out.println(sb);
    }

    private static void combination(int[] answer, int cur,  int depth, int n, int m){
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        } else{
            for (int i = cur; i <= n; i++) {
                answer[depth] = i;
                combination(answer, i, depth+1, n, m);
            }
        }
    }
}
