package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023-08-29
 * - @see  https://www.acmicpc.net/problem/1799
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 *
 */
public class BOJ_01799 {
    static class Info{
        int row, col, d;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Info(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
    static int N, answer;
    static List<Info> whiteBishop = new ArrayList<>();
    static List<Info> blackBishop = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if (Integer.parseInt(st.nextToken()) == 1){
                    if ((r+c) % 2 == 0) {
                        blackBishop.add(new Info(r, c));
                    } else{
                        whiteBishop.add(new Info(r, c));
                    }
                }
            }
        }

        boolean[] visited = new boolean[bishop.size()];
        for (int i = 0; i < bishop.size(); i++) {
            dfs(i, 0, visited);
        }

        System.out.println(answer);
    }

    private static void dfs(int idx, int count, boolean[] visited){
        if (idx == bishop.size()){
            answer = Math.max(answer, count);
            return;
        }

        if (count + (bishop.size() - idx) < answer){
            return;
        }

        Info info = bishop.get(idx);
        if (!visited[idx]){
            boolean[] dpVisited = visited.clone();
            dpVisited[idx] = true;
            update(idx, dpVisited);
            dfs(idx+1, count+1, dpVisited);
            dpVisited[idx] = false;
        }
        dfs(idx+1, count, visited);
    }

    private static void update(int idx, boolean[] visited){
        Info current = bishop.get(idx);
        for (int i = idx+1; i < bishop.size(); i++) {
            Info next = bishop.get(i);
            if (Math.abs(current.row - next.row) - Math.abs(current.col - next.col) == 0){
                visited[i] = true;
            }
        }
    }
}
