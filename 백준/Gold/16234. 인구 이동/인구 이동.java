import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023/09/02
- @see https://www.acmicpc.net/problem/16234
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # DFS
- @note
 행렬을 돌면서 인접끼리 범위가 주어진 범위 안에 있다면 list에 묶어서 추가해준다.
 추가된 리스트끼리 나눠준다.
 list에 값이 들어오지 않을 때까지 계속한다.
 */

public class Main {
    static class Info{
        int row, col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int N, L, R;
    static int[][] delta = {{-1,0}, {0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] countries = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                countries[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        int day = 0;
        while(true){
            if (check(countries)){  // 묶어서 검증하는 과정
                day++;
            } else{  // 묶인 국가들이 없다면 종료 후 지난 날짜 출력
                break;
            }
        }

        System.out.println(day);
    }

    private static void nationalMigration(List<List<Info>> unions, int[][] countries){
        for (int i = 0; i < unions.size(); i++) {
            List<Info> union = unions.get(i);

            int total = 0;
            for(Info info: union){
                total += countries[info.row][info.col];
            }

            int divide = total / union.size();
            for (Info info: union){
                countries[info.row][info.col] = divide;
            }
        }
    }

    private static List<Info> dfs(boolean[][] visited, int[][] countries, int row, int col){
        Stack<Info> stack = new Stack<>();
        List<Info> union = new ArrayList<>();

        stack.push(new Info(row, col));
        visited[row][col] = true;
        union.add(new Info(row, col));

        int tr, tc;
        while(!stack.isEmpty()){
            Info current = stack.pop();
            for (int i = 0; i < 4; i++) {
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];
                if(isIn(tr, tc) && !visited[tr][tc]){
                    int diff = Math.abs(countries[current.row][current.col] - countries[tr][tc]);
                    if (diff >= L && diff <= R){
                        stack.push(new Info(tr, tc));
                        visited[tr][tc] = true;
                        union.add(new Info(tr, tc));
                    }
                }
            }
        }
        return union;
    }

    private static boolean check(int[][] countries){
        boolean[][] visited = new boolean[N][N];
        List<List<Info>> unions = new ArrayList<>();  // 연합들의 모임

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]){
                    List<Info> union = dfs(visited, countries, r, c);
                    if (union.size() != 1){  // 연합이 1개라면 연합이 아니다!
                        unions.add(union);  // 그 외는 연합으로 쳐주기
                    }
                }
            }
        }

        if(unions.isEmpty()){  // 연합들이 하나도 생성이 되지 않는다면
            return false;
        } else{
            nationalMigration(unions, countries);
            return true;
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}