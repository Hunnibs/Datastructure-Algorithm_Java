package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 12/17/2023
- @see https://www.acmicpc.net/problem/13904
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 256MB
- @category # Graph # Greedy # Priority Queue
- @note
 1. 역정렬을 이용한 마감기간 긴 순으로 정렬
 2. 꺼내면서 확인
 */

public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Graph graph = new Graph(1001);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.setGraph(d,w);
        }

        sol(graph);
    }

    private static void sol(Graph graph){
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int point = 0;
        for (int i = 1000; i > 0; i--) {
            if (graph.getGraph(i).size() != 0){
                point = i;
                List<Integer> cur = graph.getGraph(i);
                for(Integer num : cur){
                    heap.add(num);
                }
                break;
            }
        }

        int answer = 0;
        answer += heap.poll();
        while(point != 1){
            point--;
            if (graph.getGraph(point).size() != 0){
                List<Integer> cur = graph.getGraph(point);
                for(Integer num : cur){
                    heap.add(num);
                }
            }

            if (heap.size() != 0) {
                answer += heap.poll();
            }
        }

        System.out.println(answer);
    }

    private static class Graph{
        List<List<Integer>> graph = new ArrayList<>();

        public Graph(int N) {
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Integer> getGraph(int num) {
            return graph.get(num);
        }

        public void setGraph(int d, int w) {
            graph.get(d).add(w);
        }
    }
}
