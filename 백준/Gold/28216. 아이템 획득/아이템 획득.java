import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-10-25
- @see https://www.acmicpc.net/problem/28216
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, Q;  // 상자의 개수, 이동 횟수
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        Graph rowGraph = new Graph();
        Graph colGraph = new Graph();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            rowGraph.setGraph(x, y, w);
            colGraph.setGraph(y, x, w);
        }

        int x=1, y=1, nx = 0 , ny = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nx = x + delta[d][0] * v;
            ny = y + delta[d][1] * v;

            List<Info> tmp;
            if (d % 2 == 0){
                tmp = colGraph.getGraph(nx);
                for (int j = 0; j < tmp.size(); j++) {
                    if (d == 0 && tmp.get(j).curVer > y && tmp.get(j).curVer <= ny){
                        answer += tmp.get(j).items;
                    } else if (d == 2 && tmp.get(j).curVer < y && tmp.get(j).curVer >= ny){
                        answer += tmp.get(j).items;
                    }
                }
            } else{
                tmp = rowGraph.getGraph(ny);
                for (int j = 0; j < tmp.size(); j++) {
                    if (d == 1 && tmp.get(j).curVer > x && tmp.get(j).curVer <= nx){
                        answer += tmp.get(j).items;
                    } else if (d == 3 && tmp.get(j).curVer < x && tmp.get(j).curVer >= nx){
                        answer += tmp.get(j).items;
                    }
                }
            }
            x = nx;
            y = ny;
        }
        System.out.println(answer);
    }

    static class Graph{
        List<List<Info>> graph = new ArrayList<>();

        public Graph() {
            for (int i = 0; i < 200_001; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void setGraph(int start, int end, int weight){
            graph.get(start).add(new Info(end, weight));
        }

        public List<Info> getGraph(int start){
            return graph.get(start);
        }
    }

    static class Info{
        int curVer, items;

        public Info(int curVer, int boxCnt) {
            this.curVer = curVer;
            this.items = boxCnt;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "curVer=" + curVer +
                    ", items=" + items +
                    '}';
        }
    }
}