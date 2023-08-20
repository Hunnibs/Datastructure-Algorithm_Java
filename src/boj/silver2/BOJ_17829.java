package boj.silver2;

/**

@author 이병헌
@since 2023. 08. 20
@see  https://www.acmicpc.net/problem/17829
@git
@youtube
@performance
@category # Brute Force
@note
배열의 크기를 줄이는 작업을 계속해서 반복한다. 메모리가 넉넉하게 주어져 배열을 복사해서 만들어주면서 담아 줄 예정이다. 시간은 절반씩 줄어 log N * log N 정도여서 충분히 통과할것이라 생각했다.

 소요시간 20분
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] board;
    static int[][] dpBoard;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // main
        while (N > 1) {  // 마지막에 남은 수 하나는 출력을 해줘야 한다.
            pooling();
        }

        System.out.println(board[0][0]);
    }

    private static void pooling(){
        int[] nums = new int[4];  // 수 4개 중 2번째로 큰 수를 찾아주기 위해서 배열을 만들어 정렬하고 인덱스에 접근하는 방식을 활용하려한다.
        dpBoard = new int[N/2][N/2];
          // 복사 배열에 저장공간을 추적해줄 변수로 row, col을 쓴다.
        for (int r = 0, row = 0; r < N-1; r += 2, row++){
            for (int c = 0, col = 0; c < N-1; c += 2, col++){
                nums[0] = board[r][c];
                nums[1] = board[r+1][c];
                nums[2] = board[r][c+1];
                nums[3] = board[r+1][c+1];
                Arrays.sort(nums);

                dpBoard[row][col] = nums[2];
            }
        }

        // 배열을 다시 원본 배열로 복사해서 만들고 N값을 줄여준다.
        N = N / 2;
        board = new int[N][N];
        for (int i = 0 ; i < dpBoard.length; i++){
            board[i] = Arrays.copyOf(dpBoard[i], dpBoard.length);
        }
    }
}
