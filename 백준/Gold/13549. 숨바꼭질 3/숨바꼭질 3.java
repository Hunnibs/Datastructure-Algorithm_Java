/**
 * - @author 이병헌
 * - @since 11/25/2024
 * - @see https://www.acmicpc.net/problem/13549
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # BFS
 * - @note
 * 최단 시간 경우의 수 깊이 탐색
 */

import java.util.*;
import java.io.*;

public class Main {
    private static int[] sum = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bfs(N, M);
    }

    private static void bfs(int N, int M) {
        boolean[] visited = new boolean[100_001];

        Deque<Info> pq = new ArrayDeque<>();
        pq.add(new Info(N, 0));
        visited[N] = true;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            int num = cur.num;
            int count = cur.count;

            if (num == M) {
                System.out.print(count);
                return;
            }

            int teleport = num * 2;
            while (teleport <= 100_000 && !visited[teleport]) {
                pq.add(new Info(teleport, count));
                visited[teleport] = true;
                teleport *= 2;
            }

            for (int i = 0; i < 2; i++) {
                if (num + sum[i] <= 100_000 && num + sum[i] >= 0 && !visited[num + sum[i]]) {
                    pq.add(new Info(num + sum[i], count + 1));
                    visited[num + sum[i]] = true;
                }
            }
        }
    }

    private static class Info {
        int num, count;

        public Info(int num, int count) {
            this.num = num;
            this.count = count;
        }

//        @Override
//        public int compareTo(Info o) {
//            return Integer.compare(this.count, o.count);
//        }
    }
}