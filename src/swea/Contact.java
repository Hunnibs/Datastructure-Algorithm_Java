package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023-08-23
 * - @see
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * 방향 그래프의 탐색
 */
public class Contact {
    static class Graph{
        List<List<Integer>> edgeList = new ArrayList<>();

        public Graph(int n) {
            for (int i = 0; i <= n; i++){
                edgeList.add(new ArrayList<>());
            }
        }

        public void setEdgeList(int from, int to){
            edgeList.get(from).add(to);
        }

        public List<Integer> getEdgeList(int from){
            return edgeList.get(from);
        }
    }

    static int answer;
    static int[] visited;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

       for (int test_case = 1; test_case <= 10; test_case++) {
           st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());
           int start = Integer.parseInt(st.nextToken());

           Graph graph = new Graph(100);
           st = new StringTokenizer(br.readLine());
           while (st.hasMoreTokens()) {
               graph.setEdgeList(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
           }

           visited = new int[101];
           answer = 0;
           queue.offer(start);
           visited[start] = 1;
           bfs(graph);
           search();

           sb.append("#").append(test_case).append(" ").append(answer).append("\n");
       }
        System.out.println(sb);
    }

    private static void search(){
        int depth = 0;
        for (int i = 0; i <= 100; i++){
            if (depth <= visited[i]){
                depth = visited[i];
                answer = i;
            }
        }
    }

    private static void bfs(Graph graph){
        while(!queue.isEmpty()){
            int from = queue.poll();
            List<Integer> temp = graph.getEdgeList(from);
            for (int to : temp){
                if (visited[to] == 0) {
                    visited[to] = visited[from]+1;
                    queue.offer(to);
                }
            }
        }
    }
}
