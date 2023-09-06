import java.util.*;
import java.io.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static boolean[][] field;
    static int[][] deltas = {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    static int maxN;
    static int minCost;
    static List<Core> cores;


    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for (int K = 1; K <= T ; K++) {
            setVariables();


            // 각 core별로 방향 설정해서 진행하기
            action(0, 0,0);
            sb.append("#")
                    .append(K)
                    .append(" ")
                    .append(minCost)
                    .append("\n");

        }
        System.out.println(sb);



    }

    private static void action(int depth, int cost, int selectedCores) {
        if(maxN > selectedCores + cores.size() - depth)
            return;
        if (depth == cores.size()) {
            if (maxN < selectedCores) {
                minCost = cost;
                maxN = selectedCores;
            } else if (maxN == selectedCores) {
                minCost = Math.min(minCost, cost);
            }
            return;
        }
        // draw결과가 true일 경우에만 해당 결과를 적용시킨 boolean을 넣어주고, 아니면 현재 상태와 같은 거로 간다.
        Core core = cores.get(depth);
        for (int i = 0; i < 4; i++) {
            ActionResult result = draw(core.row, core.col, i);
            if (result.result) {
                action(depth + 1, cost + result.cost, selectedCores + 1);
                redraw(core.row,core.col,i,result.cost);
            } else {
                action(depth + 1, cost, selectedCores);
            }
        }
    }

    private static void redraw(int sr, int sc, int direction, int cost) {

        int[] delta = deltas[direction];
        int nr = sr + delta[0] * cost;
        int nc = sc + delta[1] * cost;



        while (cost-- > 0) {
            field[nr][nc] = false;
            nr -= delta[0];
            nc -= delta[1];

        }


    }

    private static ActionResult draw( int sr, int sc, int direction){
        int[] delta = deltas[direction];
        int nr = sr + delta[0];
        int nc = sc + delta[1];
        int cost = 0;
        boolean result = true;
        // 가다가 막히면 돌아가야 함..
        while (isIn(nr, nc)) {
            if (field[nr][nc]) {
                result = false;
                break;
            }
            field[nr][nc] = true;
            nr += delta[0];
            nc += delta[1];
            cost++;
        }
        if (!result) {
            if (cost > 0) {
                while (cost-- > 0) {
                    nr -= delta[0];
                    nc -= delta[1];
                    field[nr][nc] = false;
                }
            }
            cost = 0;
        }
        return new ActionResult(result,cost);
    }
    private static boolean isIn(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N ;
    }
    private static void setVariables() throws IOException {
        minCost = 0;
        maxN = 0;
        N = Integer.parseInt(br.readLine());
        cores = new ArrayList<>();
        field = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = st.nextToken().equals("1");
                if (field[i][j]) {
                    if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
                    cores.add(new Core(i,j));
                }
            }
        }
    }

    static class ActionResult{
        boolean result;
        int cost;

        public ActionResult(boolean result, int cost) {
            this.result = result;
            this.cost = cost;
        }
    }

    static class Core{
        int row;
        int col;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }


    }



}