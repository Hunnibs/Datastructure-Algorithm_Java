import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Info>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int from, to, weight;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Info(to, weight));
            graph.get(to).add(new Info(from, weight));
        }

        System.out.print(prim(graph));
    }

    private static int prim(List<List<Info>> graph) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];

        pq.add(new Info(1, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            sum += cur.weight;

            List<Info> nextInfos = graph.get(cur.to);
            for(Info nextInfo : nextInfos){
                if (!visited[nextInfo.to]) pq.add(nextInfo);
            }
        }

        return sum;
    }

    public static class Info implements Comparable<Info> {
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