package boj.bronze1;

import java.util.Scanner;

/**

@author 이병헌
@since 2023. 08. 19
@see https://www.acmicpc.net/problem/11050
@git
@youtube
@performance
@category # Combination
@note */

public class BOJ_11050 {
    static int N, R, answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        combination(0, 0);

        System.out.println(answer);
    }

    private static void combination(int start, int depth){
        if (depth == R){
            answer++;
            return;
        } else{
            for (int i = start; i < N; i++){
                combination(i+1, depth+1);
            }
        }
    }
}
