package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/15/24
- @see https://www.acmicpc.net/problem/1138
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 128MB
- @category # Greedy # Hash Table
- @note
 가장 키가 작은 사람부터 순서대로
 */

public class BOJ_01138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // input end
        sol(N, people);
    }

    private static void sol(int n, int[] people) {
        int[] location = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (location[j] == 0){
                    if (cnt == people[i]){
                        location[j] = i+1;
                        break;
                    }
                    cnt++;
                }
            }
        }

        print(n, location);
    }

    private static void print(int n, int[] location){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(location[i]).append(" ");
        }

        System.out.println(sb);
    }
}
