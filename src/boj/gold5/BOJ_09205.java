package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-09-27
- @see https://www.acmicpc.net/problem/9205
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_09205 {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        test: for (int test_case = 0; test_case < t; test_case++) {
            int n = Integer.parseInt(br.readLine());

            Queue<Info> current = new ArrayDeque<>();
            Info[] convenientStore = new Info[n+1];
            boolean[] visited = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            current.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

            for (int i = 0; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                convenientStore[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            while(!current.isEmpty()){
                if (visited[n]){
                    sb.append("happy\n");
                    continue test;
                }

                Info info = current.poll();
                for (int i = 0; i <= n; i++) {
                    if(visited[i]){
                        continue;
                    }

                    Info next = convenientStore[i];
                    if (Math.abs(next.row - info.row) + Math.abs(next.col - info.col) <= 1000){
                        visited[i] = true;
                        current.offer(new Info(next.row, next.col));
                    }
                }
            }
            sb.append("sad\n");
        }
        System.out.println(sb);
    }
}
