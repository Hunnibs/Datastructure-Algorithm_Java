/**

- @author 이병헌
- @since 12/31/24
- @see https://www.acmicpc.net/problem/9252
- @git https://github.com/Hunnibs
- @youtube
- @performance O(N^2) -> 최악 1_000_000
- @category # Dynamic Programming
- @note

 */

import java.io.*;

public class Main {
    private static void solution(String X, String Y) {
        int N = X.length();
        int M = Y.length();

        int[][] count = new int[N+1][M+1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (X.charAt(r-1) == Y.charAt(c-1)) count[r][c] = count[r-1][c-1] + 1;
                else count[r][c] = Math.max(count[r-1][c], count[r][c-1]);
            }
        }

        char[] answer = new char[count[N][M]];
        int idx = count[N][M]-1;
        int r = N;
        int c = M;
        while(true) {
            if (count[r][c] == 0) break;

            if (X.charAt(r-1) == Y.charAt(c-1)) {
                answer[idx--] = X.charAt(r-1);
                r -= 1;
                c -= 1;
            } else {
                if (count[r-1][c] > count[r][c-1]) r -= 1;
                else c -= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count[N][M] + "\n");
        for (int i = 0; i < count[N][M]; i++) {
            sb.append(answer[i]);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = br.readLine();

        solution(X, Y);
    }


}