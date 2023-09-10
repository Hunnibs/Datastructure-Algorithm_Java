package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/10
- @see https://www.acmicpc.net/problem/BOJ_02623
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Graph # DFS
- @note */

public class BOJ_02623 {
    static StringBuilder sb = new StringBuilder();
    static class Graph{
        List<List<Integer>> graph = new ArrayList<>();

        public Graph(int N){
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void setGraph(int from, int to){
            graph.get(from).add(to);
        }

        public List<Integer> getGraph(int vertex){
            return graph.get(vertex);
        }
    }
    static int N, M;
    static boolean[] visited ;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()); // 맡은 그룹
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt-1; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph.setGraph(from, to);
                from = to;
            }
        }
        System.out.println(graph);
        // main
        visited = new boolean[N+1];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (flag){  // 탈출 조건
                break;
            }

            answer.clear();  // 초기화
            answer.add(i);
            visited[i] = true;
            dfs(graph, answer, i);
            visited[i] = false;
        }

        System.out.println(sb);
    }

    private static void dfs(Graph graph, List<Integer> answer, int current) {
        if (flag){  // 탈출 조건
            return;
        }

        if (answer.size() == N) {  // 기저 조건
            System.out.println(1);
            flag = true;

            for (int i = 0; i < N; i++) {
                sb.append(answer.get(i)).append("\n");
            }
            return;
        } else {
            List<Integer> nexts = graph.getGraph(current);
            System.out.println(nexts);
            for (int next : nexts) {
                if (!visited[next]) {
                    answer.add(next);
                    visited[next] = true;
                    dfs(graph, answer, next);
                    answer.remove(answer.size() - 1);
                    visited[next] = false;
                }
            }
        }
    }
}
