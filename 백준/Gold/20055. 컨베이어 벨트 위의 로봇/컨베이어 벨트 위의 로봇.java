import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 1/7/24
 * - @see https://www.acmicpc.net/problem/20055
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 512MB
 * - @category # Data Structure
 * - @note
 */

public class Main {
    private static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] durability = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        start = 0;
        end = N - 1;
        // input end
        sol(N, K, durability);
    }

    private static void sol(int N, int K, int[] durability) {
        Deque<Integer> robots = new ArrayDeque<>();
        boolean[] visited = new boolean[2 * N];

        int cnt = 0;
        while (K > 0) {
            cnt++;
            rotate(N);
            K -= move(visited, N, robots, durability);
            K -= update(visited, robots, durability);
        }

        System.out.println(cnt);
    }

    // 1번. 회전
    private static void rotate(int N) {
        start--;
        end--;
        if (start < 0) start = 2 * N - 1;
        if (end < 0) end = 2 * N - 1;
    }

    // 2번. 로봇 움직이기
    private static int move(boolean[] visited, int N, Deque<Integer> robots, int[] durability) {
        int cnt = 0;  // K값을 추적하기 위한 변수
        int size = robots.size();

        for (int i = 0; i < size; i++) {
            int index = robots.pollFirst();
            visited[index] = false;
            int next = index + 1;
            if (next >= 2 * N) {
                next = 0;
            }

            if (end == index) {  // 다음이 떨어지는 곳이라면 그냥 진행
                continue;
            }

            if (durability[next] > 0 && !visited[next]) {  // 움직일 수 있는 경우
                durability[next]--;
                if (durability[next] == 0) {
                    cnt++;
                }

                if (next == end) {  // 떨어질 위치에 온 경우 다음 움직임 때 돌리는 순간 떨어지게 되므로 추가할 필요 X
                    continue;
                }
                visited[next] = true;
                robots.offer(next);
            } else {
                visited[index] = true;
                robots.offer(index);
            }
        }

        return cnt;
    }

    // 3번. 로봇 올리기
    private static int update(boolean[] visited, Deque<Integer> robots, int[] durability) {
        if (!visited[start] && durability[start] > 0) {
            robots.offer(start);
            visited[start] = true;
            durability[start]--;
            if (durability[start] == 0) {
                return 1;
            }
        }
        return 0;
    }
}