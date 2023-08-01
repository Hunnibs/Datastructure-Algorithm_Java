package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] operators;

    static void DFS(int depth, int value){
        if (depth == N){
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }
        for (int i = 0; i < 4; i++){
            if(operators[i] > 0) {
                operators[i]--;

                if (i == 0) {
                    DFS(depth + 1, value + nums[depth]);
                } else if (i == 1) {
                    DFS(depth + 1, value - nums[depth]);
                } else if (i == 2) {
                    DFS(depth + 1, value * nums[depth]);
                } else {
                    if (value < 0) {
                        DFS(depth + 1, (Math.abs(value) / nums[depth]) * (-1));
                    } else {
                        DFS(depth + 1, value / nums[depth]);
                    }
                }
                operators[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        operators = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
