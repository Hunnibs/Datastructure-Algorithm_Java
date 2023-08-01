package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[K];
        int size = 0;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0){
                nums[--size] = 0;
            } else{
                nums[size++] = num;
            }
        }

        int answer = 0;
        for (int i = 0; i < K; i++){
            answer += nums[i];
        }
        System.out.println(answer);
    }
}
