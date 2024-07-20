import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 12/11/2023
- @see https://www.acmicpc.net/problem/1916
- @git https://github.com/Hunnibs
- @youtube
- @performance 0.5sec 128MB
- @category # Dijkstra
- @note */

public class Main {
    private static long max = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            long weight = Long.parseLong(st.nextToken());

            graph.setGraph(start, end, weight);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        // input end

        dijkstra(start, end, N, graph);
    }

    private static void dijkstra(int start, int end, int N, Graph graph){
        PriorityQueue<Info> heap = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.weight - o2.weight > 0){
                    return 1;
                } else{
                    return -1;
                }
            }
        });
        heap.add(new Info(start, 0));

        long[] shortestPath = new long[N];
        Arrays.fill(shortestPath, max);

        while (!heap.isEmpty()){
            Info current = heap.poll();
            if (current.weight > shortestPath[current.vertex]){  // 더 이상 볼 필요가 없음
                continue;
            }

            List<Info> list = graph.getGraph(current.vertex);
            for (Info next:list) {
                if (shortestPath[next.vertex] > current.weight + next.weight){
                    shortestPath[next.vertex] = current.weight + next.weight;
                    heap.add(new Info(next.vertex, shortestPath[next.vertex]));
                }
            }
        }

        System.out.println(shortestPath[end]);
    }

    private static class Graph{
        List<List<Info>> graph;
        public Graph(int N) {
            graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Info> getGraph(int vertex) {
            return graph.get(vertex);
        }

        public void setGraph(int start, int end, long weight) {
            graph.get(start).add(new Info(end, weight));
        }
    }

    private static class Info{
        int vertex;
        long weight;

        public Info(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}