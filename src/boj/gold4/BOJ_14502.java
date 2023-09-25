package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-09-25
- @see https://www.acmicpc.net/problem/14502
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # BFS
- @note

 */

public class BOJ_14502 {
    static class Info{
        private int row, col;

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
    static int N, M, safeZone, answer;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] lab;
    static List<Info> viruses = new ArrayList<>();
    static List<Info> walls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        int tmp = 0;  // 현재 세워진 벽의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    viruses.add(new Info(i, j));  // virus 정보 저장
                } else if (lab[i][j] == 0){
                    walls.add(new Info(i, j));
                } else if (lab[i][j] == 1){
                    tmp++;
                }
            }
        }

        safeZone = N * M - viruses.size() - tmp - 3;  // 현재 바이러스가 퍼지지 않은 구역 3은 추가로 세울 벽 -> 최대 세이프 존 크기
        answer = 0;
        Info[] infos = new Info[3];
        boolean[] visited = new boolean[walls.size()];
        combination(visited, infos, 0, 0);
        System.out.println(answer);
    }

    private static void bfs(int[][] virtualLab){
        Queue<Info> virus = new ArrayDeque<>();
        for (int i = 0; i < viruses.size(); i++) {
            virus.offer(viruses.get(i));
        }

        boolean[][] visited = new boolean[N][M];
        int tr, tc;
        int virtualSafeZone = safeZone;
        while(!virus.isEmpty()){
            if (virtualSafeZone < answer){
                return;
            }
            Info current = virus.poll();
            for (int i = 0; i < 4; i++) {
                tr = current.row + delta[i][0];
                tc = current.col + delta[i][1];
                if(isIn(tr, tc) && virtualLab[tr][tc] == 0 && !visited[tr][tc]){
                    visited[tr][tc] = true;
                    virtualLab[tr][tc] = 2;
                    virus.offer(new Info(tr, tc));
                    virtualSafeZone--;
                }
            }
        }
        answer = virtualSafeZone;
    }

    private static void init(Info[] infos){
        int[][] virtualLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            virtualLab[i] = lab[i].clone();
        }
        for(Info info : infos){
            virtualLab[info.row][info.col] = 1;
        }

        bfs(virtualLab);
    }

    private static void combination(boolean[] visited, Info[] infos, int start, int depth){  // 벽을 3개 고를 수 있는 경우
        if(depth == 3){
            init(infos);
            return;
        } else{
            for (int i = start; i < walls.size(); i++) {
                if (!visited[i]){
                    visited[i] = true;
                    infos[depth] = walls.get(i);
                    combination(visited, infos, start+1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}