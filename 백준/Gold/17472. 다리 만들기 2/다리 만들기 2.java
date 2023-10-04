import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

 - @author 이병헌
 - @since 2023-10-04
 - @see https://www.acmicpc.net/problem/17242
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance
 - @category #
 - @note */

public class Main {
    static class Graph{
        int start, end, weight;

        public Graph(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] bridge = new int[9][9];
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = init(map);  // 섬의 개수가 몇개인지 그리고 섬마다 번호를 2부터로 만들어준다.

        //main
        int nr, nc;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    for (int i = 0; i < 4; i++) {
                        nr = r + delta[i][0];
                        nc = c + delta[i][1];
                        if (isIn(nr, nc) && map[nr][nc] != 0) {
                            search(map, r, c, (i + 2) % 4, map[nr][nc]);
                        }
                    }
                }
            }
        }

        List<Graph> graph = new ArrayList<>();
        for (int i = 2; i < cnt + 2; i++) {
            for (int j = 2; j < i; j++) {
                if (bridge[i][j] != 0){
                    graph.add(new Graph(i-1,j-1,bridge[i][j]));
                }
            }
        }
        Collections.sort(graph, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                return o1.weight-o2.weight;
            }
        });

        parent = new int[cnt];
        for(int i = 0; i < cnt; i++){
            parent[i] = i;
        }

        int cost = 0;
        for (int i = 0; i < graph.size(); i++) {
            if(find(graph.get(i).start) != find(graph.get(i).end)) {
                union(graph.get(i).start, graph.get(i).end);
                cost += graph.get(i).weight;
                continue;
            }
        }

        if (check(parent)) {
            System.out.println(cost);
        } else{
            System.out.println(-1);
        }
    }

    private static boolean check(int[] parent){
        int a = find(1);
        for (int i = 2; i < parent.length; i++) {
            if (a != find(i)){
                return false;
            }
        }
        return true;
    }
    private static void search(int[][] map, int row, int col, int nd, int start){
        int nr = row + delta[nd][0], nc = col + delta[nd][1];
        int cnt = 1;
        while(isIn(nr, nc)){
            if (map[nr][nc] != 0 && map[nr][nc] != start && cnt > 1) {
                if (bridge[start][map[nr][nc]] == 0) {
                    bridge[start][map[nr][nc]] = cnt;
                    bridge[map[nr][nc]][start] = cnt;
                } else{
                    bridge[start][map[nr][nc]] = Math.min(cnt, bridge[start][map[nr][nc]]);
                    bridge[map[nr][nc]][start] = Math.min(cnt, bridge[map[nr][nc]][start]);
                }
                return;
            }

            if (map[nr][nc] != 0){
                if (map[nr][nc] == start || cnt == 1){
                    return;
                }
            }

            cnt++;
            nr += delta[nd][0];
            nc += delta[nd][1];
        }
    }

    private static void bfs(int[][] map, int row, int col, int idx){
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(row, col));
        map[row][col] = idx;

        int nr, nc;
        while(!queue.isEmpty()){
            Info current = queue.poll();
            for (int i = 0; i < 4; i++) {
                nr = current.row + delta[i][0];
                nc = current.col + delta[i][1];

                if (isIn(nr, nc) && map[nr][nc] == 1){
                    map[nr][nc] = idx;
                    queue.offer(new Info(nr, nc));
                }
            }
        }
    }

    private static int init(int[][] map){
        int idx = 2;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c] == 1){
                    bfs(map, r, c, idx);
                    idx++;
                }
            }
        }
        return idx - 1;
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a > b){
            parent[a] = b;
        } else{
            parent[b] = a;
        }
    }

    private static int find(int x){
        if (parent[x] == x){
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 & row < N && col >= 0 && col < M;
    }
}