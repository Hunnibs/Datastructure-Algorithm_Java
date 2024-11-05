/**
 * - @author 이병헌
 * - @since 11/5/2024
 * - @see https://www.acmicpc.net/problem/30960
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance O(logN)
 * - @category # Sort # BruteForce
 * - @note
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        int[] sub = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            sub[i] = students[i + 1] - students[i];
        }

        int[] even = new int[N];
        int[] odd = new int[N];
        for (int i = 0; i < N - 1; i += 2) {
            even[i / 2 + 1] = even[i / 2] + sub[i];
        }
        for (int i = 1; i < N - 1; i += 2) {
            odd[i / 2 + 1] = odd[i / 2] + sub[i];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N - 2; i += 2) {
            int sum = students[i + 2] - students[i];
            sum += (even[i / 2] + (odd[N / 2] - odd[(i + 3) / 2]));
            answer = Math.min(sum, answer);
        }

        System.out.println(answer);
    }
}