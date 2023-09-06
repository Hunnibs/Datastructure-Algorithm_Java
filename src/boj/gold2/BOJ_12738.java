package boj.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**

 - @author 이병헌
 - @since 2023-09-06
 - @see https://www.acmicpc.net/problem/12015
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance
 - @category # Binary Search
 - @note

 */

public class BOJ_12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(A[0]);
        for (int i = 1; i < N; i++) {
            if(list.get(list.size()-1) < A[i]){
                list.add(A[i]);
            } else{
                int idx = Collections.binarySearch(list, A[i]);
                if (idx >= 0) {
                    continue;
                } else {
                    list.set(Math.abs(idx) - 1, A[i]);
                }
            }
        }

        System.out.println(list.size());
    }
}
