package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 1/22/2024
- @see https://www.acmicpc.net/problem/3020
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 128MB
- @category # Binary Search
- @note */

public class BOJ_03020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N / 2];
        int[] up = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(up);
        Arrays.sort(down);

        // input end
        int min = Integer.MAX_VALUE;
        int cnt = 1;
        for (int i = 1; i <= H; i++) {
            int sum = binarySearch(down, i, 0, N/2) + binarySearch(up, H-i+1, 0, N/2);
            if (sum < min){
                cnt = 1;
                min = sum;
            } else if(sum == min){
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }

    private static int binarySearch(int[] array, int target, int left, int right){
        while (left < right){
            int mid = (left + right) / 2;

            if (array[mid] >= target){
                right = mid;
            } else{
                left = mid + 1;
            }
        }

        return array.length - right;
    }
}
