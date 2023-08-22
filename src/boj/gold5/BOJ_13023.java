package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-22
 * - @see https://www.acmicpc.net/problem/13023
 * - @git
 * - @youtube
 * - @performance 12616MB	172ms
 * - @category # DFS # AdjList
 * - @note
 */
public class BOJ_13023 {
    static class Node{
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, flag;
    static Node[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new Node[n];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }

        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            visited[i] = true;
            dfs(i, 0);
            if (flag == 1){
                break;
            }
            visited[i] = false;
        }

        System.out.println(flag);
    }

    private static void dfs(int current, int depth){
        if (depth == 4){
            flag = 1;
            return;
        } else{
            for (Node tmp = adjList[current]; tmp != null; tmp = tmp.next){
                if (!visited[tmp.vertex]) {
                    visited[tmp.vertex] = true;
                    dfs(tmp.vertex, depth + 1);
                    if (flag == 1) {
                        return;
                    }
                    visited[tmp.vertex] = false;
                }
            }
        }
    }
}
