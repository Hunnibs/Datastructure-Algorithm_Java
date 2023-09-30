package boj.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 10/1/2023
 * - @see https://www.acmicpc.net/problem/17244
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 * 전형적인 BFS 문제 최단시간 내에 탈출하라!
 * <p>
 * 집은 늘 벽으로 둘러쌓여있음 -> isIn 갖다버려
 * <p>
 * 물건의 개수 카운팅해줄 것 -> 탈출 조건
 * 시작 위치, 끝나는 위치 알고 있을 것
 * 끝나는 위치에 도달했을 때 카운팅해줬던 값과 같은 수를 가지고 있다면 탈출!
 */

public class BOJ_17244 {
    static class Info {
        int row, col, count, bit;

        public Info(int row, int col, int count, int bit) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.bit = bit;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "row=" + row +
                    ", col=" + col +
                    ", count=" + count +
                    ", bit=" + bit +
                    '}';
        }
    }

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M, count = 0;
    static Info start, end;
    static Info[] items = new Info[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    start = new Info(i, j, 0, 0);
                    map[i][j] = '.';
                } else if (map[i][j] == 'E') {
                    end = new Info(i, j, 0, 0);
                } else if (map[i][j] == 'X') {
                    items[count++] = new Info(i, j, 0, 0);
                }
            }
        }
        System.out.println(bfs(map));
    }

    private static int bfs(char[][] map) {
        boolean[][][] visited = new boolean[32][N][M];  // 달이 차오른다와 같은 방식으로 움직여줄 예정
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(start.row, start.col, 0, 0b00000));

        Info current;
        int nr, nc, time = 0, size;
        int num, bit;
        while (!queue.isEmpty()) {
            time++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                for (int j = 0; j < 4; j++) {
                    nr = current.row + delta[j][0];
                    nc = current.col + delta[j][1];
                    if (!visited[current.bit][nr][nc] && map[nr][nc] == '.'){
                        visited[current.bit][nr][nc] = true;
                        queue.offer(new Info(nr, nc, current.count, current.bit));
                    } else if (!visited[current.bit][nr][nc] && map[nr][nc] == 'X'){
                        num = check(nr, nc);
                        bit = update(num, current.bit);
                        visited[bit][nr][nc] = true;
                        if (bit == current.bit){
                            queue.offer(new Info(nr, nc, current.count, bit));
                        }else {
                            queue.offer(new Info(nr, nc, current.count + 1, bit));
                        }
                    } else if (map[nr][nc] == 'E' && current.count == count){
                        return time;
                    }
                }
            }
        }
        return time;
    }

    private static int check(int row, int col){
        for (int i = 0; i < items.length; i++) {
            if (items[i].row == row && items[i].col == col){
                return i;
            }
        }
        return -1;
    }

    private static int update(int num, int bit){
        if (num == 0){
            bit |= 1;
        } else if (num == 1){
            bit |= (1 << 1);
        } else if (num == 2){
            bit |= (1 << 2);
        } else if (num == 3){
            bit |= (1 << 3);
        } else if (num == 4){
            bit |= (1 << 4);
        }

        return bit;
    }
}
