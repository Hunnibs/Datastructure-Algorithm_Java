package boj.silver1;

/**

 @author 이병헌
 @since 2023. 8. 5.
 @see https://www.acmicpc.net/problem/1914
 @git
 @youtube
 @performance
 @category # 재귀
 @note
원판의 개수가 주어졌을 때 하노이 탑 규칙에 따라 주어진 원판을 1번 기둥에서 3번 기둥으로 모두 옮겨야 하는 문제

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_01914 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static BigInteger K = new BigInteger("1");

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            K = K.subtract(new BigInteger("1"));
            System.out.println(K);
            System.out.println(sb);
        } else{
            for (int i = 0; i < N; i++){
                K = K.multiply(new BigInteger("2"));
            }
            K = K.subtract(new BigInteger("1"));
            System.out.println(K);
        }
    }

    private static void hanoi(int num, int start, int tmp, int end) {
        if (num == 0) {
            return;
        }
        K = K.add(new BigInteger("1"));
        hanoi(num-1, start, end, tmp);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(num-1, tmp, start, end);
    }
}
