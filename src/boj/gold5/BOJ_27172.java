package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 12/20/23
 * - @see https://www.acmicpc.net/problem/27172
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 1024MB
 * - @category # Dynamic Programming # Memorization
 * - @note

 */

public class BOJ_27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        int[] tmp = new int[1_000_001];
        int[] answer = new int[1_000_001];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
            tmp[nums.get(i)] = 1;
            max = Math.max(max, nums.get(i));
        }

        // input end
        for (int i = 0; i < N; i++) {
            int mul = 2;
            int num = nums.get(i);
            while (num * mul <= max){
                if (tmp[num * mul] == 1){
                    answer[num]++;
                    answer[num * mul]--;
                }

                mul++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[nums.get(i)]).append(" ");
        }

        System.out.println(sb);
    }
}