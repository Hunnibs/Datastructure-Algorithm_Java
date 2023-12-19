import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/19/23
- @see https://www.acmicpc.net/problem/15654
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 512MB
- @category # Combination
- @note */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        Arrays.sort(nums);
        int[] answer = new int[m];
        boolean[] visited = new boolean[n];

        combination(visited, 0, 0, answer, nums, n, m);
    }

    private static void combination(boolean[] visited, int depth, int cur, int[] answer, int[] nums, int n, int m){
        if (depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println("");
            return;
        } else{
            for (int i = cur; i < n; i++) {
                if (!visited[i]) {
                    answer[depth] = nums[i];
                    visited[i] = true;
                    combination(visited, depth+1, cur, answer, nums, n, m);
                    visited[i] = false;
                }
            }
        }
    }
}