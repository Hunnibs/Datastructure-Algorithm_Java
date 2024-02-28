package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2/10/24
 * - @see https://www.acmicpc.net/problem/1043
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2sec 128MB
 * - @category # Dynamic Programming
 * - @note
 */

public class BOJ_01043 {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> people = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        for (int i = 0; i < know; i++) {
            int num = Integer.parseInt(st.nextToken());
            people.add(num);
        }

        Graph graph = new Graph(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int participant = Integer.parseInt(st.nextToken());
            for (int j = 0; j < participant; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph.setGraph(i, num);
            }
        }

        // input end
        System.out.println(sol(people, graph));
    }

    private static int sol(Queue<Integer> people, Graph graph) {
        boolean[] visited = new boolean[N+1];

        while(!people.isEmpty()){
            int num = people.poll();
            if (!visited[num]){
                visited[num] = true;
                int idx = 0;
                while (idx < graph.size()){
                    List<Integer> party = graph.getGraph(idx);
                    if (party.contains(num)){
                        extension(people, party);
                        graph.deleteGraph(idx);
                    } else{
                        idx++;
                    }
                }
            }
        }

        return graph.size();
    }

    private static void extension(Queue<Integer> people, List<Integer> party){
        for (int i = 0; i < party.size(); i++) {
            people.add(party.get(i));
        }
    }

    private static class Graph {
        List<List<Integer>> graph = new ArrayList<>();

        public Graph(int M) {
            for (int i = 0; i < M; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Integer> getGraph(int i) {
            return graph.get(i);
        }

        public void setGraph(int from, int to) {
            graph.get(from).add(to);
        }

        public void deleteGraph(int i){
            graph.remove(i);
        }

        public int size(){
            return graph.size();
        }
    }
}
