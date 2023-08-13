package boj.silver2;

/**

@author 이병헌
@since 2023. 08. 13
@see https://www.acmicpc.net/problem/11724
@git
@youtube
@performance
@category # Graph
@note
 2차원 배열을 통한 그래프 구현을 할 예정
 시간은 3초 메모리도 512MB가 주어지면서 N이 1000이기 때문에 연결리스트로 구현을 하고 값을 탐색하는데 시간을 n만큼 사용하더라도 충분히 가능하다고 생각했다.

 ++ 간선으로 연결되지 않은 정점들에 대해서도 새로운 그래프가 생성된다는 사실을 간과해서 틀렸다.
 이를 해결하기 위해서 정점 별로 따로 그래프 생성 여부 체크를 해주는 배열을 두어 그래프가 만들어지지 않은 정점들은 아무곳에도 연결되지 않은 정점으로 보아 더 추가해주었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static boolean[] vertex;
    static boolean[][] visited, connect;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;

        connect = new boolean[N+1][N+1];  // 간선의 연결을 기록해 줄 2차원 배열을 생성해준다. 정점은 1부터 시작하므로 한 칸 더 크게 만들어준다.
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connect[u][v] = true;
            connect[v][u] = true;
        }

        visited = new boolean[N+1][N+1];  // 모두 다 담았다면 한 정점에 연결된 정점들에 대해 dfs 탐색을 통해 몇 개의 리스트들이 새로 만들어지는지 확인한다.
        vertex = new boolean[N+1];
        for (int r = 1; r <= N; r++){
            for (int c = 1; c <= N; c++) { // 한 정점에 연결된 정점의 정보들을 Deque에 넣어준다. 그리고 BFS를 돌면서 중복 체크를 진행하지 않기 위해 체크했음을 확인해준다.
                if (!visited[r][c] && connect[r][c]){
                    vertex[r] = true;
                    vertex[c] = true;
                    visited[r][c] = true;
                    visited[c][r] = true;
                    dq.add(c);
                }
            }
            if (!dq.isEmpty()){
                bfs();
                answer++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!vertex[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(){
        while(!dq.isEmpty()){
            int r = dq.pollFirst();
            for (int c = 1; c <= N; c++) {
                if (!visited[r][c] && connect[r][c]){
                    vertex[r] = true;
                    vertex[c] = true;
                    visited[r][c] = true;
                    visited[c][r] = true;
                    dq.add(c);
                }
            }
        }
    }
}
