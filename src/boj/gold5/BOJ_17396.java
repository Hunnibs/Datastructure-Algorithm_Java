package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 12/10/23
- @see https://www.acmicpc.net/problem/17396
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 512MB
- @category #
- @note
 최단거리 알고리즘 중 하나를 사용
 조건
 1. 그래프 정점의 값이 1이면 이동이 불가능하다.
 2. 양방향 그래프이며, 가중치는 양의 가중치로 주어진다.
 -> 다익스트라 알고리즘의 사용
 */

public class BOJ_17396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] vertex = new int[N];
        for (int i = 0; i < N; i++) {
            vertex[i] = Integer.parseInt(st.nextToken());
        }

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            graph.setGraph(start, end, weight);
            graph.setGraph(end, start, weight);
        }

        // input end

        dijkstra(graph, vertex);
    }

    private static void dijkstra(Graph graph, int[] vertex){
        PriorityQueue<Info> heap = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.weight > o2.weight){
                    return 1;
                } else{
                    return -1;
                }
            }
        });

        heap.add(new Info(0, 0));

        long[] shortestPath = new long[vertex.length];
        Arrays.fill(shortestPath, max);
        shortestPath[0] = 0;

        while(!heap.isEmpty()){
            Info info = heap.poll();

            if (shortestPath[info.vertex] < info.weight){
                continue;
            }

            List<Info> infoList = graph.getGraph(info.vertex);
            for (Info next:infoList) {
                if(shortestPath[next.vertex] > info.weight + next.weight){
                    if (vertex[next.vertex] == 1 && next.vertex != vertex.length-1){
                        continue;
                    }

                    shortestPath[next.vertex] = info.weight + next.weight;
                    heap.add(new Info(next.vertex, shortestPath[next.vertex]));
                }
            }
        }

        if (shortestPath[vertex.length-1] != max){
            System.out.println(shortestPath[vertex.length-1]);
        }else{
            System.out.println(-1);
        }
    }

    private static final long max = Long.MAX_VALUE;

    private static class Info{
        int vertex;
        long weight;

        public Info(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    private static class Graph{
        List<List<Info>> graph = new ArrayList<>();
        public Graph(int N) {
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void setGraph(int start, int end, long weight) {
            graph.get(start).add(new Info(end, weight));
        }

        public List<Info> getGraph(int N) {
            return graph.get(N);
        }
    }
}
