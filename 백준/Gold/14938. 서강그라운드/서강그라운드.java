import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/10/24
- @see https://www.acmicpc.net/problem/14938
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 128MB
- @category #
- @note */

public class Main {
    private static final int Max = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[n][n];
        fill(graph, n);
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());
            graph[a][b] = l;
            graph[b][a] = l;
        }

        // input end
        sol(graph, items, n, m);
    }

    private static void sol(int[][] graph, int[] items, int n, int m){
        floyd(graph, n);
        System.out.println(forChicken(graph, items, n, m));
    }

    private static void fill(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Max;
            }
        }
    }

    private static int forChicken(int[][] graph, int[] items, int n, int m){
        int[] maxItems = new int[n];
        for (int i = 0; i < n; i++) {
            maxItems[i] = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= m){
                    maxItems[i] += items[j];
                }
            }
        }

        Arrays.sort(maxItems);
        return maxItems[n-1];
    }

    private static void floyd(int[][] graph, int n){
        for (int K = 0; K < n; K++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][K] + graph[K][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
    }
}