import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 12/2/23
 * - @see https://www.acmicpc.net/problem/16928
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1초, 512MB
 * - @category # BFS
 * - @note
 * 주사위를 '최소'로 던져서 100번 칸에 도달할 수 있는 경우
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ladder = new int[101];
        int[] snake = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake[u] = v;
        }
        // 입력 끝

        System.out.println(bfs(ladder, snake));
    }

    private static int bfs(int[] ladder, int[] snake) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        queue.offer(1);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= 6; j++) {
                    if (cur + j == 100) {  // 루프 종료 조건
                        return depth;
                    }

                    if (cur + j < 100 && !visited[cur + j]) {  // 100을 넘어가는 경우는 고려 X
                        if (ladder[cur + j] != 0) {
                            queue.offer(ladder[cur + j]);
                            visited[ladder[cur + j]] = true;
                        } else if (snake[cur + j] != 0) {
                            queue.offer(snake[cur + j]);
                            visited[snake[cur + j]] = true;
                        } else {
                            queue.offer(cur + j);
                            visited[cur + j] = true;
                        }
                    }
                }
            }
        }

        return 0;  // 항상 100번 칸에 도착할 수 있는 경우만 주어지므로 의미없는 return 값
    }
}