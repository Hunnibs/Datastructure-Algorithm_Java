package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023-10-10
 * - @see https://www.acmicpc.net/problem/29792
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming
 * - @note
 */

public class BOJ_29792 {
    static class Boss {
        long hp, meso;

        public Boss(long hp, long meso) {
            this.hp = hp;
            this.meso = meso;
        }
    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] damages = new long[N];
        for (int i = 0; i < N; i++) {
            damages[i] = Long.parseLong(br.readLine());
        }

        Boss[] bosses = new Boss[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            bosses[i] = new Boss(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        List<Long> maxMesos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            maxMesos.add(killBoss(bosses, damages[i]));
        }

        Collections.sort(maxMesos, Collections.reverseOrder());
        long answer = 0;
        for (int i = 0; i < M; i++) {
            answer += maxMesos.get(i);
        }

        System.out.println(answer);
    }

    private static long killBoss(Boss[] bosses, Long damage) {
        long[][] dp = new long[K + 1][901];

        for (int i = 1; i <= K; i++) {
            long time = bosses[i].hp / damage;
            if (bosses[i].hp % damage != 0){
                time++;
            }
            for (int j = 0; j <= 900; j++) {
                if (j < time) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], bosses[i].meso + dp[i-1][(int)(j-(time))]);
                }
            }
        }


        return dp[K][900];
    }
}
