package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01753 {
    static class Info{
        int vertex, weight;

        public Info(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Graph{
        List<List<Info>> edgeList = new ArrayList<>();

        public Graph(int V){
            for (int i = 0; i < V; i++){
                edgeList.add(new ArrayList<>());
            }
        }

        public void setEdgeList(int u, int v, int w){
            edgeList.get(u).add(new Info(v, w));
        }

        public List<Info> getEdgeList(int idx){
            return  edgeList.get(idx);
        }
    }

    static int V, E, K;
    final static int INF = Integer.MAX_VALUE;
    static int[] shortestPath;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine())-1;

        Graph graph = new Graph(V);

        int u, v, w;
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken())-1;
            v = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            graph.setEdgeList(u, v, w);
        }

        // main
        shortestPath = new int[V];
        Arrays.fill(shortestPath, INF);
        shortestPath[K] = 0;
        dijkstra(graph);

        for (int i = 0; i < V; i++){
            if (shortestPath[i] == INF){
                sb.append("INF").append("\n");
            } else {
                sb.append(shortestPath[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(Graph graph){
        PriorityQueue<Info> heap = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.weight - o2.weight;
            }
        });
        heap.add(new Info(K, 0));

        while (!heap.isEmpty()){
            Info current = heap.poll();
            List<Info> currentVertex = graph.getEdgeList(current.vertex);

            for (Info next : currentVertex){
                if (shortestPath[next.vertex] > next.weight + current.weight){
                    shortestPath[next.vertex] = next.weight + current.weight;
                    heap.add(new Info(next.vertex, shortestPath[next.vertex]));
                }
            }
        }
    }
}
