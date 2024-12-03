package boj.silver4;

/**

- @author 이병헌
- @since 10/11/2024
- @see https://www.acmicpc.net/problem/29791
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note
 쿨타임
에르다 노바 : 100초 오리진 : 360초
면역 시간 : 각 90초
 */

import java.util.*;
import java.io.*;

public class BOJ_29791 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nova = new int[N];
        int[] origin = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            nova[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nova);
        Arrays.sort(origin);

        int coolTime = 0;
        int novaCnt = 0;
        for (int shortCut : nova){
            if (shortCut >= coolTime){
                novaCnt++;
                coolTime = shortCut + 100;
            }
        }

        coolTime = 0;
        int originCnt = 0;
        for (int shortCut : origin){
            if (shortCut >= coolTime){
                originCnt++;
                coolTime = shortCut + 360;
            }
        }

        System.out.print(novaCnt + " " + originCnt);
    }
}