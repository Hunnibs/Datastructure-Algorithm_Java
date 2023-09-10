package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023/09/10
- @see https://www.acmicpc.net/problem/BOJ_02623
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Graph # Topological Sort
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
    static int N, M, check;
    static boolean[] visited ;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        int[] degree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()); // 맡은 그룹
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt-1; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph.setGraph(from, to);
                degree[to]++;
                from = to;
            }
        }

        // main
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0){
                queue.offer(i);
            }
        }

        topologicalSort(graph, queue, degree);

        if (check == N) {
            System.out.println(sb);
        } else{
            System.out.println(0);
        }
    }

    private static void topologicalSort(Graph graph, Queue<Integer> queue, int[] degree) {
        while(!queue.isEmpty()){
            int next = queue.poll();
            sb.append(next).append("\n");
            check++;

            List<Integer> nexts = graph.getGraph(next);
            for (int nextVertex : nexts) {
                if (--degree[nextVertex] == 0){
                    queue.offer(nextVertex);
                }
            }
        }
    }
}
