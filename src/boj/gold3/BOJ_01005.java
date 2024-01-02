package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 12/26/2023
 * - @see https://www.acmicpc.net/problem/1005
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # Topological Sort
 * - @note
 */

public class BOJ_01005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] times = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            Graph graph = new Graph(N);
            int[] degree = new int[N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;

                graph.setGraph(from, to);
                degree[to]++;
            }

            int W = Integer.parseInt(br.readLine())-1;
            // input end

            sb.append(topologicalSort(graph, degree, times, W)).append("\n");
        }
        System.out.println(sb);
    }

    private static int topologicalSort(Graph graph, int[] degree, int[] times, int W) {
        Queue<Integer> queue = new ArrayDeque<>();

        int[] totalTime = new int[times.length];
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                totalTime[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            List<Integer> cur = graph.getGraph(from);
            for (int to : cur) {
                degree[to]--;
                totalTime[to] = Math.max(totalTime[to], totalTime[from] + times[to]);
                if (degree[to] == 0) {
                    if (to == W){
                        return totalTime[to];
                    } else {
                        queue.add(to);
                    }
                }
            }
        }
        return totalTime[W];
    }

    private static class Graph {
        List<List<Integer>> graph = new ArrayList<>();

        public Graph(int N) {
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void setGraph(int from, int to) {
            graph.get(from).add(to);
        }

        public List<Integer> getGraph(int from) {
            return graph.get(from);
        }
    }
}
