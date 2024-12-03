/**
 - @author 이병헌
 - @since 8/5/24
 - @see https://www.acmicpc.net/problem/01647
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance
 - @category # kruskal # union-find
 - @note
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws Exception{
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(6);
        a.add(1);

        Collections.sort(a, Collections.reverseOrder());
        System.out.println(a);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y){
            if (x > y) {
                parent[y] = x;
            } else{
                parent[x] = y;
            }
        }
    }

    private static int find(int x){
        if (x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static class Info implements Comparable<Info>{
        int from, to, weight;

        public Info(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(weight, o.weight);
        }
    }
}