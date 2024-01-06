package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2024-01-03
- @see https://www.acmicpc.net/problem/21760
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_21760 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int B = 1;
            int A = B * K;
            int region = A * N * M * (M-1) / 2;
            int world = (N-1) * M * B * N * M / 2;
            int total = region + world;
//            int sum = 1;
//
//            int answer = 0;
//            while(total * sum <= D){
//                answer = total * sum++;
//            }
//
//            if (answer == 0){
//                sb.append(-1).append("\n");
//            } else{
//                sb.append(answer).append("\n");
//            }
            int div = D / total;
            if (div == 0){
                sb.append("-1").append("\n");
            } else{
                sb.append(div * total).append("\n");
            }
        }
        System.out.print(sb);
    }
}
