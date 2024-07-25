/**

- @author 이병헌
- @since 7/25/24
- @see https://www.acmicpc.net/problem/2467
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Two Pointer
- @note

 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] flask = new int[N];
        for(int i = 0; i < N; i++){
            flask[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        int left = 0;
        int right = 0;
        int minSum = Integer.MAX_VALUE;

        while(s < e){
            int abs = Math.abs(flask[s] + flask[e]);
            if (abs == 0){
                left = flask[s];
                right = flask[e];
                break;
            }

            if (abs < minSum){
                minSum = abs;
                left = flask[s];
                right = flask[e];
            }

            if(flask[s] + flask[e] < 0){
                s++;
            } else{
                e--;
            }
        }

        System.out.println(left + " " + right);
    }
}