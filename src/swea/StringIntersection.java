package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 9/9/2023
- @see
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Hash
- @note */

public class StringIntersection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] ns = new String[N];
            String[] ms = new String[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ns[i] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                ms[i] = st.nextToken();
            }

            // main
            HashSet<String> map = new HashSet<>();
            for (int i = 0; i < N; i++) {
                map.add(ns[i]);
            }

            int answer = 0;
            for (int i = 0; i < M; i++) {
                if (map.contains(ms[i])) {
                    answer++;
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
