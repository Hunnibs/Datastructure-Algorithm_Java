package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

 @author 이병헌
 @since 2023. 8. 10.
 @see https://www.acmicpc.net/problem/17406
 @git
 @youtube
 @performance
 @category # Implemetation # Permutation
 @note
주어진 순서대로 배열을 규칙에 따라 돌리면 되는 문제로 처음에 풀었다.
 규칙에 따라 돌리는 것은 순서에 따라 전부 다른 결과를 도출하기 때문에 순열로 돌리는 순서를 전부 계산해주고 케이스 별로 전부 계산했을 때 최소인 값을 출력해야한다.
 돌릴 수 있는 순서의 순열은 총 K!가 나온다. 즉 2^K
 N x N 배열이라고 가정했을 때
 배열을 새로 돌릴 때마다 복사본을 만들어야하므로 N만큼 시간이 들며, rotate 메소드는 최악의 경우 N^2, search method는 N^2만큼 탐색을 진행한다.
 총 2 x (N ^ 2) x N x (2 ^ K)만큼의 연산을 진행해줘야하며 복사 배열을 생성하므로 Memory 낭비도 심하다.
 하지만 50 x 50 배열이 최대 사이즈에 6!만큼을 연산하므로 시간 안에 계산이 가능하다.
 */

public class BOJ_17406 {
    static class Info{
        int r, c, s;
        public Info(int r, int c, int s) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
        }

    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int row, col, seq;
    static int answer = Integer.MAX_VALUE;
    static int[][] board, duplicate;
    static int[] per;
    static boolean[] visited;
    static ArrayList<Info> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        duplicate = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[K+1];
        per = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken())-1;
            col = Integer.parseInt(st.nextToken())-1;
            seq = Integer.parseInt(st.nextToken());
            list.add(new Info(row, col, seq));
        }
        permutation(0);

        System.out.println(answer);
    }

    static void search() {
        for (int r = 0; r < N; r++) {
            int sum = 0;
            for (int c = 0; c < M; c++) {
                sum += duplicate[r][c];
            }
            answer = Math.min(answer, sum);
        }
    }

    static void rotate(int num) {
        int r = row - num, c = col - num;
        int tmp = duplicate[r][c];
        for (int i = 0; i < num * 2; i++) {
            duplicate[r][c] = duplicate[r+1][c];
            r++;
        }
        for (int i = 0; i < num * 2; i++) {
            duplicate[r][c] = duplicate[r][c+1];
            c++;
        }

        for (int i = 0; i < num * 2; i++) {
            duplicate[r][c] = duplicate[r-1][c];
            r--;
        }

        for (int i = 0; i < num * 2; i++) {
            duplicate[r][c] = duplicate[r][c-1];
            c--;
        }
        duplicate[r][c+1] = tmp;
    }

    static void permutation(int depth) {
        if (depth == K) {
            for (int r = 0; r < N; r++){
                duplicate[r] = Arrays.copyOf(board[r], board[r].length);
            }
            for (int i = 0; i < K; i++){
                row = list.get(per[i]).r;
                col = list.get(per[i]).c;
                seq = list.get(per[i]).s;
                for (int j = 1; j <= seq; j++) {
                    rotate(j);
                }
            }
            search();
            return;
        } else{
            for (int i = 0; i < K; i++){
                if (!visited[i]) {
                    visited[i] = true;
                    per[depth] = i;
                    permutation(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}