package boj.silver3;

/**

@author 이병헌
@since 2023. 08. 20
@see https://www.acmicpc.net/problem/1051
@git
@youtube
@performance
@category # Brute Force
@note 
 사각형 크기마다 비교
 
 30분 소요
 */ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01051 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, answer;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 행 당 누적합 형식으로 배열에 저장해준다.
        square = new int[N][M];
        for (int r = 0; r < N; r++){
            String S = br.readLine();
            for (int c = 0; c < M; c++){
                square[r][c] = (S.charAt(c) - '0');
            }
        }

        // 만들 수 있는 최대 정사각형 크기
        int size = 0;
        if (N > M){
            size = N;
        } else{
            size = M;
        }

        for (int i = 0; i < size; i++){
            check(i);
        }

        System.out.println(answer);
    }

    private static void check(int size){
        for (int r = 0; r < N-size; r++){
            for (int c = 0; c < M-size; c++){
                if (square[r][c] == square[r+size][c] && square[r][c] == square[r][c+size] && square[r][c] == square[r+size][c+size]){
                    answer = (size+1) * (size+1);
                }
            }
        }
    }
}
