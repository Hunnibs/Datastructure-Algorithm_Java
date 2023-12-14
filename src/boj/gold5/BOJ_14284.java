package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 12/14/2023
 * - @see https://www.acmicpc.net/problem/14284
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2sec 512MB
 * - @category # Dijkstra
 * - @note
 */

public class BOJ_14284 {
    private static final long max = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            long weight = Long.parseLong(st.nextToken());

            graph.setGraph(start, end, weight);
            graph.setGraph(end, start, weight);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int t = Integer.parseInt(st.nextToken()) - 1;

        // input end

        dijkstra(graph, n, s, t);
    }

    private static void dijkstra(Graph graph, int n, int s, int t) {
        PriorityQueue<Info> heap = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.weight > o2.weight) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        heap.add(new Info(s, 0));

        long[] shortestPath = new long[n];
        Arrays.fill(shortestPath, max);

        while (!heap.isEmpty()) {
            Info current = heap.poll();
            if (current.weight > shortestPath[current.end]) {
                continue;
            }
            List<Info> list = graph.getGraph(current.end);
            for (Info next : list) {
                if (shortestPath[next.end] > current.weight + next.weight) {
                    shortestPath[next.end] = current.weight + next.weight;
                    heap.add(new Info(next.end, shortestPath[next.end]));
                }
            }
        }

        System.out.println(shortestPath[t]);
    }

    private static class Graph {
        List<List<Info>> graph = new ArrayList<>();

        public Graph(int N) {
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Info> getGraph(int start) {
            return graph.get(start);
        }

        public void setGraph(int start, int end, long weight) {
            graph.get(start).add(new Info(end, weight));
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "graph=" + graph +
                    '}';
        }
    }

    private static class Info {
        int end;
        long weight;

        public Info(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
}
