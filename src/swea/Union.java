package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-10-10
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Union-Find
- @note */

public class Union {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            boolean[] check = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                int a = find(i);
                if (!check[a]) {
                    check[a] = true;
                }
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (check[i]){
                    cnt++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a){
        if (parent[a] == a){
            return parent[a];
        } else{
            return parent[a] = find(parent[a]);
        }
    }

    private static void union(int a, int b){
        int A = find(a);
        int B = find(b);

        if (A != B){
            parent[A] = B;
        }
    }
}
