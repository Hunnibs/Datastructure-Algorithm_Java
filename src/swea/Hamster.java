package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamster {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N, X, M;
    static int l, r, s;
    static int[] sums;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 우리
            X = Integer.parseInt(st.nextToken());  // 우리 당 최대 햄스터 수
            M = Integer.parseInt(st.nextToken());  // 기록 개수
            answer = new int[N];
            sums = new int[N+1];

            for (int m = 0; m < M; m++){
                st = new StringTokenizer(br.readLine());
                l = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

            }
        }
    }

    static void permutation(int depth){
        if (depth == N) {

            return;
        } else{
            for (int i = 0; i < X; i++){
                answer[depth] = i;
                sums[depth] = sums[depth-1] + i;
                permutation(depth+1);
            }
        }
    }
}
