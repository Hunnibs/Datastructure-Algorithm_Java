package boj.gold4;

import java.util.*;
import java.io.*;
/**

- @author 이병헌
- @since 6/13/2024
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_01922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int from, to, weight;
        List<List<Info>> network = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            network.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            network.get(from).add(new Info(to, weight));
            network.get(to).add(new Info(from, weight));
        }

        System.out.print(prim(network));
    }

    private static int prim(List<List<Info>> network){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(1, 0));
        boolean[] visited = new boolean[network.size()+1];

        int sum = 0;
        while (!pq.isEmpty()) {
            Info curInfo = pq.poll();

            if (visited[curInfo.to]) continue;

            sum += curInfo.weight;
            visited[curInfo.to] = true;

            pq.addAll(network.get(curInfo.to));
        }

        return sum;
    }

    private static class Info implements Comparable<Info> {
        int to, weight;

        public Info(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

