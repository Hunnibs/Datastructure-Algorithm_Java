package boj.gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-09-19
- @see https://www.acmicpc.net/problem/15644
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_15644 {
    static class Info{
        int redRow, redCol, blueRow, blueCol, d, count;
        int[] list = new int[11];

        public Info(int redRow, int redCol, int blueRow, int blueCol, int d, int count) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.d = d;
            this.count = count;
        }

        public void add(int count, int root){
            list[count] = root;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return redRow == info.redRow && redCol == info.redCol && blueRow == info.blueRow && blueCol == info.blueCol && d == info.d && count == info.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(redRow, redCol, blueRow, blueCol, d, count);
        }

        @Override
        public String toString() {
            return "Info{" +
                    "redRow=" + redRow +
                    ", redCol=" + redCol +
                    ", blueRow=" + blueRow +
                    ", blueCol=" + blueCol +
                    ", d=" + d +
                    ", count=" + count +
                    '}';
        }
    }

    static int N, M, answer;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            map[r] = s.toCharArray();
        }

        int redRow = 0, redCol = 0, blueRow = 0, blueCol = 0, goalRow = 0, goalCol = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 'R') {  // 빨간 공 초기 위치
                    redRow = r;
                    redCol = c;
                } else if (map[r][c] == 'B'){  // 파란 공 초기 위치
                    blueRow = r;
                    blueCol = c;
                } else if (map[r][c] == 'O'){  // 골인 지점 위치
                    goalRow = r;
                    goalCol = c;
                }
            }
        }

        // main
        Queue<Info> queue = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            Info info = new Info(redRow, redCol, blueRow, blueCol, i, 0);
            info.list[0] = i;
            queue.offer(info);
        }

        int[] result = bfs(queue, goalRow, goalCol);

        if (answer > 0){
            System.out.println(answer);
            for (int i = 0; i < answer; i++) {
                decode(result[i]);
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static Info move(Info current){
        Stack<Info> stack = new Stack<>();
        stack.push(current);

        while(!stack.isEmpty()){
            current = stack.pop();

            int nrRed = current.redRow + delta[current.d][0];
            int ncRed = current.redCol + delta[current.d][1];
            int nrBlue = current.blueRow + delta[current.d][0];
            int ncBlue = current.blueCol + delta[current.d][1];

            if (notWall(nrRed, ncRed) && map[nrRed][ncRed] != '#' && notWall(nrBlue, ncBlue) && map[nrBlue][ncBlue] != '#'){
                if (goalIn(nrRed, ncRed)){
                    answer = current.count+1;
                } else if (goalIn(nrBlue, ncBlue)){  // 더 이상 탐색을 하지 말아야하는 상황
                    return null;
                }

                stack.push(new Info(nrRed, ncRed, nrBlue, ncBlue, current.d, current.count));
            } else if (notWall(nrRed, ncRed) && map[nrRed][ncRed] != '#'){  // 빨간공만 움직일 수 있을 때
                nrBlue = current.blueRow;
                ncBlue = current.blueCol;
                if (goalIn(nrRed, ncRed)){
                    answer = current.count+1;
                }
                if (!same(nrRed, ncRed, nrBlue, ncBlue)) {
                    stack.push(new Info(nrRed, ncRed, nrBlue, ncBlue, current.d, current.count));
                }
            } else if (notWall(nrBlue, ncBlue) && map[nrBlue][ncBlue] != '#'){  // 파란공만 움직일 수 있을 때
                nrRed = current.redRow;
                ncRed = current.redCol;
                if (goalIn(nrBlue, ncBlue)){  // 더 이상 탐색을 하지 말아야하는 상황
                    return null;
                }
                if (!same(nrRed, ncRed, nrBlue, ncBlue)) {
                    stack.push(new Info(nrRed, ncRed, nrBlue, ncBlue, current.d, current.count));
                }
            }
        }

        return current;
    }

    private static int[] bfs(Queue<Info> queue, int goalRow, int goalCol){
        while(!queue.isEmpty()){
            Info current = queue.poll();
            if (current.count >= 10){  // 10번 이상 탐색하지 않는다.
                return current.list;
            }

            Info next = move(current);
            if (answer != 0){  // 빨간 공은 이미 구멍에 빠졌다.
                if (next == null){  // 파란 공도 빠졌다.
                    answer = 0;
                    continue;
                } else {
                    return current.list;
                }
            }

            if (next == null){
                continue;
            }

            if (current.equals(next)){  // 움직임이 없는 상황
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (i == (current.d + 2) % 4){  // 기울어졌던 곳으로 다시 기울일 필요는 없다.
                    continue;
                } else{
                    Info info = new Info(next.redRow, next.redCol, next.blueRow, next.blueCol, i, current.count+1);
                    info.list = current.list.clone();
                    info.list[current.count+1] = i;
                    queue.offer(info);
                }
            }
        }
        return null;
    }

    private static void decode(int num){
        switch (num){
            case 0:
                sb.append("U");
                break;
            case 1:
                sb.append("R");
                break;
            case 2:
                sb.append("D");
                break;
            case 3:
                sb.append("L");
                break;
        }
    }

    private static boolean notWall(int row, int col){  // 가장 바깥쪽 라인은 모두 벽으로 지정
        return row >= 1 && row < N-1 && col >= 1 && col < M-1;
    }

    private static boolean same(int nrRed, int ncRed, int nrBlue, int ncBlue){
        return nrRed == nrBlue && ncRed == ncBlue;
    }

    private static boolean goalIn(int row, int col){
        return map[row][col] == 'O';
    }
}
