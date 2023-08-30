package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-30
 * - @see https://www.acmicpc.net/problem/10971
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # DFS
 * - @note
 */
public class BOJ_10971 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, visited, map, 1, 0);
            visited[i] = false;
        }

        if (answer == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    private static void dfs(int init, int start, boolean[] visited, int[][] map, int depth, int sum){
        if(depth == visited.length){
            if (map[start][init] != 0) {
                answer = Math.min(answer, sum + map[start][init]);
            }
            return;
        } else{
            for (int c = 0; c < visited.length; c++) {
                if (!visited[c] && map[start][c] != 0){
                    visited[c] = true;
                    dfs(init, c, visited, map, depth+1, sum+map[start][c]);
                    visited[c] = false;
                }
            }
        }
    }
}
