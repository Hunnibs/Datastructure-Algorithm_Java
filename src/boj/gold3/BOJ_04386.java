package boj.gold3;

import java.util.*;
import java.io.*;

/**

- @author 이병헌
- @since 6/14/2024
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_04386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        double x, y;
        coordinate[] coordinates = new coordinate[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            coordinates[i] = new coordinate(x, y);
        }

        List<List<Info>> infos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            infos.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                double distance = Math.sqrt(Math.pow((coordinates[i].x - coordinates[j].x), 2) + Math.pow((coordinates[i].y - coordinates[j].y), 2));
                infos.get(i).add(new Info(j, distance));
                infos.get(j).add(new Info(i, distance));
            }
        }

        System.out.printf("%.2f", prim(infos));
    }

    private static double prim(List<List<Info>> infos){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0));
        boolean[] visited = new boolean[infos.size()];

        double sum = 0;
        while (!pq.isEmpty()) {
            Info curInfo = pq.poll();
            if (visited[curInfo.to]) continue;

            visited[curInfo.to] = true;
            sum += curInfo.weight;
            for(Info nextInfo : infos.get(curInfo.to)){
                pq.add(nextInfo);
            }
        }

        return sum;
    }

    private static class coordinate{
        double x, y;

        public coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Info implements Comparable<Info>{
        int to;
        double weight;

        public Info(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            if (this.weight > o.weight) return 1;
            else if (this.weight < o.weight) return -1;

            return 0;
        }
    }
}