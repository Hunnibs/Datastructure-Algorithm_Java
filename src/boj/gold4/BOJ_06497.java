package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-23
 * - @see https://www.acmicpc.net/problem/6497
 * - @git
 * - @youtube
 * - @performance
 * - @category # Kruskal
 * - @note
 *
 */
public class BOJ_06497 {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static class DisjointSet{
        int n;
        int[] parent;

        public DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            make();
        }

        void make(){
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if (x == parent[x]){
                return x;
            } else{
                return parent[x] = find(parent[x]);
            }
        }

        public boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB){
                return false;
            } else{
                parent[rootA] = rootB;
                return true;
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0){
                break;
            }

            int sum = 0;
            Edge[] edgeList = new Edge[m];
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                sum += z;
                edgeList[i] = new Edge(x, y, z);
            }
            Arrays.sort(edgeList);

            DisjointSet set = new DisjointSet(n);

            int result = 0; // MST 비용
            int count = 0; // 연결된 간선 개수
            for (Edge edge : edgeList) {
                if (set.union(edge.from, edge.to)) {
                    result += edge.weight;
                    if (++count == n - 1) {
                        break;
                    }
                }
            }

            sb.append(sum - result).append("\n");
        }
        System.out.println(sb);
    }
}
