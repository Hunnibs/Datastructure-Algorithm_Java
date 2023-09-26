package boj.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-09-26
 * - @see https://www.acmicpc.net/problem/1365
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming # Binary Search
 * - @note
 */

public class BOJ_01365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (list.isEmpty()){
                list.add(target);
                continue;
            } else {
                int idx = Math.abs(Collections.binarySearch(list, target))-1;
                if (idx > list.size()-1){
                    list.add(target);
                } else{
                    list.set(idx, target);
                }
            }
        }

        System.out.println(N - list.size());
    }
}
