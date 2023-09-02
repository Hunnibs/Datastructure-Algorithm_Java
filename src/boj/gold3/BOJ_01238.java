package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023/09/02
 * - @see https://www.acmicpc.net/problem/1238
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Dijkstra
 * - @note
 * N개의 정점과 M개의 간선, 목적 정점 X가 주어진다. (1000, 10000, N)
 * 그래프는 방향 그래프로 주어진다. 
 * 특정 정점에서 정점 X까지 도달했다가 특정 정점으로 돌아와야 할 때 최단 경로
 *
 * ++ 1 <= T <= 100이므로 양의 가중치의 방향 그래프를 만들어준다.
 */
public class BOJ_01238 {
    static class Info{
        int vertex, weight;

        public Info(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Graph{
        List<List<Info>> Graph = new ArrayList<>();
        
        public Graph(int N){
            for (int i = 0; i < N+1; i++) {
                Graph.add(new ArrayList<>());
            }
        }

        public List<Info> getGraph(int idx){
            return Graph.get(idx);
        }

        public void setGraph(int from, int to, int weight) {
            Graph.get(from).add(new Info(to, weight));
        }
    }
    
    static int N, M, X;
    final static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.setGraph(from, to, weight);
        }

        // main
        int answer = -1;
        for (int i = 1; i <= N; i++) {
            if (i == X){  // X마을에서 출발하는 경우는 따로 고려해주지 않아도 된다.
                continue;
            } else{
                answer = Math.max(answer, dijkstra(graph, i, X) + dijkstra(graph, X, i));
            }
        }

        System.out.println(answer);
    }

    private static int dijkstra(Graph graph, int start, int end){
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {  // 가중치가 작은 순으로 꺼내기 위해서 pq 재설정
            @Override
            public int compare(Info o1, Info o2) {
                return o1.weight - o2.weight;
            }
        });

        int[] shortestPath = new int[N+1];  // 경로룰 지나가면서 최단거리를 업데이트하며 저장해줄 배열
        Arrays.fill(shortestPath, INF);
        shortestPath[start] = 0;  // 시작 지점은 우선 0으로 초기화한다.

        pq.offer(new Info(start, 0));
        while(!pq.isEmpty()){
            Info current = pq.poll();
            List<Info> nextVillage = graph.getGraph(current.vertex);  // 현재 정점과 연결된 다른 정점들의 정보를 하나에 저장

            for(Info next : nextVillage){
                if (shortestPath[next.vertex] > next.weight + current.weight){  // 다음 정점까지의 경로가 이미 저장된 경로보다 작다면 업데이트를 해줄 수 있다.
                    shortestPath[next.vertex] = next.weight + current.weight;
                    pq.offer(new Info(next.vertex, shortestPath[next.vertex]));  // 늘 헷갈리는 부분: 힙에 저장되어야할 정보는 다음 정점과 **시작 정점부터 해당 정점까지의 거리**
                }
            }
        }

        return shortestPath[end];
    }
}
