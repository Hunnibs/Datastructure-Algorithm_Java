package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-10-04
- @see https://www.acmicpc.net/problem/28325
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_28325 {
    static int N;
    static long value = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        long[] anthill = new long[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            anthill[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;

        sol(0, anthill, visited, answer);

        System.out.println(value);
    }

    private static void sol(int start, long[] anthill, boolean[] visited, long answer){
        for (int i = start; i < N; i++) {
            if (anthill[i] != 0){
                answer += anthill[i];
            } else{
                if (i == 0){
                    sol(start+1, anthill, visited, answer);
                    visited = new boolean[N];
                    answer++;
                    visited[i] = true;
                }else if (i == N-1){
                    if (!visited[i-1] && !visited[0]){
                        answer++;
                    }
                } else{
                    if(!visited[i-1]){
                        answer++;
                        visited[i] = true;
                    }
                }
            }
        }
        value = Math.max(answer, value);
    }
}
