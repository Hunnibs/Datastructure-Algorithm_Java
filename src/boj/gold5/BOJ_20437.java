package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
- @author 이병헌
- @since 1/20/24
- @see https://www.acmicpc.net/problem/20437
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 1024MB
- @category # Dynamic Programming # subSet
- @note
 알파벳 별로 index에 따라 위치를 저장해놓는다
 26개의 알파벳에 총 10_000 문자열 길이로 2차원 배열을 만들어도 260_000이면 메모리가 넉넉하다.
 */

public class BOJ_20437 {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            // input end

            int[] alphaCnt = new int[26];  // 알파벳이 몇 번 등장했는지를 추적해줄 배열
            int[][] dp = new int[26][10_000];  // row 알파벳 col 문자열 길이만큼
            for (int i = 1; i <= W.length(); i++) {
                int alphabet = W.charAt(i-1) - 'a';
                dp[alphabet][alphaCnt[alphabet]++] = i;
            }
            // memorization end

            if(check(alphaCnt, K)) {
                sol(K-1, dp, alphaCnt);
            } else{
                sb.append(-1);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int[] alphaCnt, int k) {  // 나와야할 문자열 개수보다 모두 적으면 그냥 -1 출력하고 끝내면 된다.
        for (int i = 0; i < alphaCnt.length; i++) {
            if (alphaCnt[i] >= k){
                return true;
            }
        }

        return false;
    }

    private static void sol(int k, int[][] dp, int[] alphaCnt) {
        int max = 0, min = 10_001;
        int tmp = 0;
        for (int i = 0; i < 26; i++) {
            int cnt = alphaCnt[i];
            if (cnt - k > 0) {
                for (int j = 0; j < cnt - k; j++) {
                    tmp = dp[i][j+k] - dp[i][j] + 1;
                    max = Math.max(max, tmp);
                    min = Math.min(min, tmp);
                }
            }
        }

        sb.append(min).append(" ").append(max);
    }
}
