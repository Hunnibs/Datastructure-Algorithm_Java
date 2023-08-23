package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-23
 * - @see https://www.acmicpc.net/problem/17471
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */
public class BOJ_17471 {
    static boolean[] visited;
    static int cntA = 0, cntB = 0, answer = Integer.MAX_VALUE;
    static int[] people;
    static ArrayList<Integer> team1 = new ArrayList<>(), team2 = new ArrayList<>();
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        people = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++){
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[i][to-1] = 1;
                adjMatrix[to-1][i] = 1;
            }
        }

        subset(N, 0);

        if (answer == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    private static void subset(int nth, int depth){
        if (nth == depth){
            visited = new boolean[adjMatrix.length];
            if (!team1.isEmpty() && !team2.isEmpty()) {
                visited[team1.get(0)] = true;
                visited[team2.get(0)] = true;
                team1check(team1.get(0));
                team2check(team2.get(0));
                for (int i = 0 ; i < adjMatrix.length; i++) {
                    if (!visited[i]){
                        return;
                    }
                }
                answer = Math.min(answer, Math.abs(cntA - cntB));
            }
            return;
        } else{
            team1.add(depth);
            cntA += people[depth];
            subset(nth, depth+1);
            cntA -= people[depth];
            team1.remove(team1.size()-1);
            team2.add(depth);
            cntB += people[depth];
            subset(nth, depth+1);
            team2.remove(team2.size()-1);
            cntB -= people[depth];
        }
    }

    private static void team1check(int num) {
        for (int c = 0; c < adjMatrix[num].length; c++){
            if (team1.contains(c) && adjMatrix[num][c] == 1 && !visited[c]){
                visited[c] = true;
                team1check(c);
            }
        }
    }

    private static void team2check(int num) {
        for (int c = 0; c < adjMatrix[num].length; c++){
            if (team2.contains(c) && adjMatrix[num][c] == 1 && !visited[c]){
                visited[c] = true;
                team2check(c);
            }
        }
    }
}
