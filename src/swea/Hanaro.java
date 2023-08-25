package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-24
 * - @see
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * prim 알고리즘을 활용한 최소 신장 트리
 */
public class Hanaro {
    static class Vertex implements Comparable<Vertex>{
        int no;
        double weight;

        public Vertex(int no, double weight) {
            super();
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int V = Integer.parseInt(br.readLine());
            double[][] adjMatrix = new double[V][V];

            double[] xArray = new double[V];
            double[] yArray = new double[V];

            st = new StringTokenizer(br.readLine());
            for (int i =0 ; i < V; i++){
                xArray[i] = Double.parseDouble(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i =0 ; i < V; i++){
                yArray[i] = Double.parseDouble(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    adjMatrix[i][j] = Math.pow(Math.abs(xArray[i] - xArray[j]), 2) + Math.pow(Math.abs(yArray[i] - yArray[j]), 2);
                }
            }

            boolean[] visited = new boolean[V];
            double[] minEdge = new double[V];
            PriorityQueue<Vertex> pQueue = new PriorityQueue<>();

            Arrays.fill(minEdge, Double.MAX_VALUE);
            minEdge[0] = 0;  // 트리 구성의 시작 정점을 0으로 지정
            pQueue.offer(new Vertex(0, minEdge[0]));

            double result = 0;
            int minVertex = 0, cnt = 0;
            double min = 0;
            while (!pQueue.isEmpty()) {
                // step1 : 미방문 정점 중 최소간선비용의 정점을 선택
                Vertex vertex = pQueue.poll();
                minVertex = vertex.no;
                min = vertex.weight;
                if (visited[minVertex]) {
                    continue;
                }

                // step2 : 방문(트리) 정점에 추가
                visited[minVertex] = true;
                result += min;
                if (++cnt == V) {
                    break;
                }

                // step 3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려
                for (int i = 0; i < V; i++) {
                    if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                        minEdge[i] = adjMatrix[minVertex][i];
                        pQueue.add(new Vertex(i, minEdge[i]));
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(Math.round(E * result)).append("\n");
        }
        System.out.println(sb);
    }
}
