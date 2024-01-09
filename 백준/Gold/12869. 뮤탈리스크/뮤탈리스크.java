import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/9/24
- @see https://www.acmicpc.net/problem/12869
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 512MB
- @category # BFS # Greedy
- @note
 가장 체력이 많은 SCV에게 첫 번째로 공격해야 한다.
 */

public class Main {
    private static final int[] damage = {1, 3, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] hp = new int[3];
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        // input end
        int answer = sol(N, hp);
        System.out.println(answer);
    }

    private static int sol(int N, int[] hp){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(hp);

        int cnt = 0;
        boolean flag = false;
        while(!queue.isEmpty() && !flag){
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                Arrays.sort(tmp);  // 체력이 가장 큰 것부터 공격하기 위해서
                if (tmp[0] - damage[0] > 0 || tmp[1] - damage[1] > 0 || tmp[2] - damage[2] > 0){
                    queue.offer(new int[]{tmp[0] - damage[0], tmp[1] - damage[1], tmp[2] - damage[2]});
                } else{
                    flag = true;
                }

                if (tmp[0] - damage[1] > 0 || tmp[1] - damage[0] > 0 || tmp[2] - damage[2] > 0){
                    queue.offer(new int[]{tmp[0] - damage[1], tmp[1] - damage[0], tmp[2] - damage[2]});
                } else{
                    flag = true;
                }
            }
        }

        return cnt;
    }
}