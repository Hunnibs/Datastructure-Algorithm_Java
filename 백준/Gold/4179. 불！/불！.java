/**

- @author 이병헌
- @since 1/7/2025
- @see https://www.acmicpc.net/problem/4179
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 256MB
- @category # BFS
- @note
 가장 빠른 탈출 시간
 -> BFS 문제
지훈 : 4방향 중 한 방향으로 이동(한 명)
 불 : 4방향 모두 확산 (여러개 가능)
 -> count 방식 bfs, 불을 늘 먼저 확산하고 나머지 지훈이 이동 경우 고려
 미로 가장자리가 탈출
 벽 통과 불가
 */

import java.io.*;
import java.util.*;

public class Main {
    private static class Position {
        int r, c;

        public Position() {}

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int solution(char[][] map, int R, int C, List<Position> fire, Position jihoon) {
        Deque<Position> fireQueue = new ArrayDeque<>();
        Deque<Position> jihoonQueue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        for (Position pos : fire) {
            fireQueue.offerLast(pos);
        }
        jihoonQueue.offerLast(jihoon);
        visited[jihoon.r][jihoon.c] = true;

        int count = 0;
        while(!jihoonQueue.isEmpty()) {
            count++;
            int size = fireQueue.size();
            for (int i = 0; i < size; i++) {
                Position pos = fireQueue.pollFirst();
                moveFire(map, fireQueue, R, C, pos.r, pos.c);
            }

            size = jihoonQueue.size();
            for (int i = 0; i < size; i++) {
                Position pos = jihoonQueue.pollFirst();
                if (moveJihoon(map, visited, jihoonQueue, R, C, pos.r, pos.c)) return count;
            }
        }

        return -1;
    }

    private static boolean moveJihoon(char[][] map, boolean[][] visited, Deque<Position> queue, int R, int C, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (isEdge(R, C, nr, nc)) return true;  // 탈출 성공

            if (!isWall(map, nr, nc) && !isFire(map, nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.offerLast(new Position(nr, nc));
            }
        }
        return false;
    }

    private static void moveFire(char[][] map, Deque<Position> queue, int R, int C, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (!isEdge(R, C, nr, nc) && !isWall(map, nr, nc) && !isFire(map, nr, nc)) {
                map[nr][nc] = 'F';
                queue.offerLast(new Position(nr, nc));
            }
        }
    }

    private static boolean isEdge(int R, int C, int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }

    private static boolean isWall(char[][] map, int r, int c) {
        return map[r][c] == '#';
    }

    private static boolean isFire(char[][] map, int r, int c) {
        return map[r][c] == 'F';
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        List<Position> fire = new ArrayList<>();
        Position jihoon = new Position();
        for (int r = 0; r < R; r++) {
            String S = br.readLine();
            for (int c = 0; c < C; c++) {
                char type = S.charAt(c);
                map[r][c] = type;

                if (type == 'F') fire.add(new Position(r, c));
                if (type == 'J') jihoon = new Position(r, c);
            }
        }

        int answer = solution(map, R, C, fire, jihoon);

        if (answer == -1) System.out.print("IMPOSSIBLE");
        else System.out.print(answer);
    }
}