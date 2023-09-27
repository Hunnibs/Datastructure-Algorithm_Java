package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-09-27
- @see
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class PersonNetwork {
    final static int MAX = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[][] network = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(network[i], MAX);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    network[i][j] = Integer.parseInt(st.nextToken());
                    if(network[i][j] == 0){
                        network[i][j] = MAX;
                    }
                }
            }

            for (int via = 0; via < n; via++) {
                for (int start = 0; start < n; start++) {
                    for (int end = 0; end < n; end++) {
                        network[start][end] = Math.min(network[start][end], network[start][via] + network[via][end]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                network[i][i] = 0;
            }

            int answer = MAX;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += network[j][i];
                }
                answer = Math.min(sum, answer);
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
