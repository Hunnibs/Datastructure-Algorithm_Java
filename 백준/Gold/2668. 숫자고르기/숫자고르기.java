import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2/18/24
 * - @see https://www.acmicpc.net/problem/2668
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 128MB
 * - @category # Graph
 * - @note
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // input end;
        System.out.print(sol(nums));
    }

    private static StringBuilder sol(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<Integer> answers = new ArrayList<>();
        int[] check = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        // 인덱스와 자신의 숫자가 같다면 무조건 포함한다. 반대라면 계산을 해준다.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i) {
                answers.add(i);
            } else {
                if (!visited[i]) {
                    check[i] = checkSize(nums, i);
                    if (check[i] != 0) {
                        visitedCheck(visited, nums, i);
                    }
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (0 != check[i]) {
                add(answers, nums, i);
            }
        }

        sb.append(answers.size()).append("\n");

        Collections.sort(answers);
        for (int i = 0; i < answers.size(); i++) {
            sb.append(answers.get(i)).append("\n");
        }
        return sb;
    }

    private static void visitedCheck(boolean[] visited, int[] nums, int i) {
        int cur = i;

        while (true) {
            int next = nums[cur];
            if (next == i) {
                break;
            }

            if (!visited[next]) {
                cur = next;
                visited[next] = true;
            }
        }
    }


    private static int checkSize(int[] nums, int i) {
        boolean[] visited = new boolean[nums.length];

        int size = 1;
        int cur = i;
        visited[cur] = true;
        while (true) {
            int next = nums[cur];
            if (next == i) {
                break;
            }

            if (!visited[next]) {
                size++;
                cur = next;
                visited[next] = true;
            } else {
                return 0;
            }
        }

        return size;
    }

    private static void add(List<Integer> answers, int[] nums, int index) {
        if (answers.contains(index)) {
            return;
        }

        answers.add(index);
        int cur = index;
        while (true) {
            int next = nums[cur];
            if (next == index) {
                break;
            }

            answers.add(next);
            cur = next;
        }
    }
}