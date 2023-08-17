package swea;
/**

@author 이병헌
@since 2023. 8. 9.
@see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYlH3z4K78kDFAVR&contestProbId=AV5LtJYKDzsDFAXc&probBoxId=AYnN7JhqMPoDFAUe&type=PROBLEM&problemBoxTitle=0807%EC%A3%BC&problemBoxCnt=4
@git
@youtube
@performance O(N^2)
@category # BFS
@note
특정 칸이 visited 처리가 되어있지 않다면 탐색을 시작한다.
        해당 칸에서 -로 이동할 때의 방 이동 수와 +로 이동할 때의 방 이동 수를 체크해준다. 이후 queue가 비어서 나올 때 두 개의 값을 합쳐준다면 배열 한 번만 탐색하면서 queue 연산만 해준다면 연산이 끝나므로 O(N^2)에 끝난다.
        */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SquareRoom {
    static class Info {
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int cnt1, cnt2;
    static int[][] rooms;
    static boolean[][] visited;
    static Deque<Info> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            rooms = new int[N][N];
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    rooms[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            cnt2 = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        dq.offer(new Info(r, c));
                        cnt1 = rooms[r][c];
                        int tmp = bfs();
                        if (answer == tmp && cnt2 > cnt1) {
                            cnt2 = cnt1;
                        } else if (answer < tmp) {
                            cnt2 = cnt1;
                            answer = tmp;
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(cnt2).append(" ").append(answer + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        int num1 = 0, num2 = 0;
        int x, y;
        int tr, tc;

        while (!dq.isEmpty()) {
            x = dq.peekFirst().x;
            y = dq.pollFirst().y;
            for (int i = 0; i < 4; i++) {
                tr = x + delta[i][0];
                tc = y + delta[i][1];
                if (isIn(tr, tc) && !visited[tr][tc]) {
                    if (rooms[tr][tc] == rooms[x][y] + 1) {
                        visited[tr][tc] = true;
                        dq.offer(new Info(tr, tc));
                        num1++;
                    } else if (rooms[tr][tc] == rooms[x][y] - 1) {
                        visited[tr][tc] = true;
                        dq.offer(new Info(tr, tc));
                        cnt1--;
                        num2++;
                    }
                }
            }
        }

        return num1 + num2;
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
