package boj.bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/3/23
- @see https://www.acmicpc.net/problem/2420
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Math
- @note */

public class BOJ_02420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        System.out.println(Math.abs(N-M));
    }
}
