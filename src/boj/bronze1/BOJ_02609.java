package boj.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-28
 * - @see https://www.acmicpc.net/problem/2609
 * - @git
 * - @youtube
 * - @performance
 * - @category # Brute Force
 * - @note
 */
public class BOJ_02609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answerA = 1, answerB = 0;
        for (int i = Math.min(A, B); i > 1; i--){
            if (A % i == 0 && B % i == 0){
                answerA = i;
                break;
            }
        }

        int sumA = 1, sumB = 1;
        while (true){
            if (A * sumA == B * sumB){
                answerB = A * sumA;
                break;
            } else{
                if (A * sumA > B * sumB){
                    sumB++;
                } else if (A * sumA < B * sumB){
                    sumA++;
                }
            }
        }

        System.out.println(answerA);
        System.out.println(answerB);
    }
}
