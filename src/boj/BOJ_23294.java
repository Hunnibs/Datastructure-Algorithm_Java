package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023-10-24
- @see https://www.acmicpc.net/problem/23294
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_23294 {
    static int N, Q, C;
    static int curCache;
    static int[] caches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        caches = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            caches[i] = Integer.parseInt(st.nextToken());
        }

        sol();
    }

    private static void sol(){

    }

    private static void access(int browserNo){
        if (curCache + caches[browserNo] <= C){
            curCache += caches[browserNo];
        }
    }
}
