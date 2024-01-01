package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 1/1/2024
 * - @see https://www.acmicpc.net/problem/14567
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 5sec 256MB
 * - @category #
 * - @note
 */

public class BOJ_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        int[] weight = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            graph.setGraph(from, to);
            weight[to]++;
        }

        // input end
        topologicalSort(graph, weight);
    }

    private static void topologicalSort(Graph graph, int[] weight){
        int N = weight.length;
        int[] answer = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if(weight[i] == 0){
                queue.offer(i);
                answer[i] = 1;
            }
        }

        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int to = queue.poll();
                List<Integer> list = graph.getGraph(to);
                for (int from : list) {
                    weight[from]--;
                    if (weight[from] == 0) {
                        queue.offer(from);
                        answer[from] = depth;
                    }
                }
            }
        }

        print(answer);
    }

    private static void print(int[] answer){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static class Graph {
        List<List<Integer>> graph = new ArrayList<>();

        public Graph(int N) {
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Integer> getGraph(int to) {
            return graph.get(to);
        }

        public void setGraph(int from, int to) {
            graph.get(from).add(to);
        }
    }
}
