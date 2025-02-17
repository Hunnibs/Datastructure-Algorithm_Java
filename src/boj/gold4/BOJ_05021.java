package boj.gold4;

/**

 - @author 이병헌
 - @since 12/4/2024
 - @see https://www.acmicpc.net/problem/5021
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance 1sec 128MB
 - @category # Graph # Tree
 - @note

 */

import java.util.*;
import java.io.*;

public class BOJ_05021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String founder = br.readLine();

        HashMap<String, Double> royalRelationRate = new HashMap<>();
        HashMap<String, Integer> degree = new HashMap<>();
        HashMap<String, List<String>> hierarchy = new HashMap<>();
        hierarchy.put(founder, new ArrayList<>());

        royalRelationRate.put(founder, 1.0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            if (!hierarchy.containsKey(parent1)) hierarchy.put(parent1, new ArrayList<>());
            if (!hierarchy.containsKey(parent2)) hierarchy.put(parent2, new ArrayList<>());
            hierarchy.get(parent1).add(name);
            hierarchy.get(parent2).add(name);
            if (!degree.containsKey(parent1)) degree.put(parent1, 0);
            if (!degree.containsKey(parent2)) degree.put(parent2, 0);
            royalRelationRate.put(name, 0.0);
            degree.put(name, 2);
        }

        royalRelationRate = bfs(royalRelationRate, hierarchy, degree);

        List<Info> candidates = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String candidate = br.readLine();
            if (royalRelationRate.containsKey(candidate)) {
                candidates.add(new Info(candidate, royalRelationRate.get(candidate)));
            }
        }
        Collections.sort(candidates);
        System.out.println(candidates.get(0).name);
    }

    private static HashMap<String, Double> bfs(HashMap<String, Double> royalRelationRate, HashMap<String, List<String>> hierarchy, HashMap<String, Integer> degree){
        Queue<String> queue = new ArrayDeque<>();
        for(String name : degree.keySet()){
            if (degree.get(name) == 0) queue.add(name);
        }

        while(!queue.isEmpty()){
            String name = queue.poll();

            if (!hierarchy.containsKey(name)) continue;
            List<String> children = hierarchy.get(name);

            for (String child : children) {
                double half = royalRelationRate.get(name) != null ? royalRelationRate.get(name) / 2 : 0.0;
                royalRelationRate.put(child, royalRelationRate.get(child) + half);
                degree.put(child, degree.get(child) - 1);
                if (degree.get(child) == 0) queue.add(child);
            }
        }
        return royalRelationRate;
    }

    private static class Info implements Comparable<Info>{
        String name;
        double rate;

        public Info(String name, double rate) {
            this.name = name;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "name='" + name + '\'' +
                    ", rate=" + rate +
                    '}';
        }

        @Override
        public int compareTo(Info o) {
            return -Double.compare(this.rate, o.rate);
        }
    }
}
