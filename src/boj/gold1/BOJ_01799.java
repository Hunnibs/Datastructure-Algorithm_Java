package boj.gold1;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Info> whiteBishop = new ArrayList<>();
        List<Info> blackBishop = new ArrayList<>();
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

        boolean[] visited = new boolean[whiteBishop.size()];
        for (int i = 0; i < whiteBishop.size();i++){
            dfs(i, 0, visited, whiteBishop);
        }
        int tmp = answer;
        answer = 0;
        visited = new boolean[blackBishop.size()];
        for (int i = 0; i < blackBishop.size(); i++) {
            dfs(i, 0, visited, blackBishop);
        }

        System.out.println(tmp + answer);
    }

    private static void dfs(int idx, int count, boolean[] visited, List<Info> bishop){
        if (idx == bishop.size()){
            answer = Math.max(answer, count);
            return;
        }

        Info info = bishop.get(idx);
        if (!visited[idx]){
            boolean[] dpVisited = visited.clone();
            dpVisited[idx] = true;
            update(idx, dpVisited, bishop);
            dfs(idx+1, count+1, dpVisited, bishop);
            dpVisited[idx] = false;
        }
        dfs(idx+1, count, visited, bishop);
    }

    private static void update(int idx, boolean[] visited, List<Info> bishop){
        Info current = bishop.get(idx);
        for (int i = idx+1; i < bishop.size(); i++) {
            Info next = bishop.get(i);
            if (Math.abs(current.row - next.row) - Math.abs(current.col - next.col) == 0){
                visited[i] = true;
            }
        }
    }
}
