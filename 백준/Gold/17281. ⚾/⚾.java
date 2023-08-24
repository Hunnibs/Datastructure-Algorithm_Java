import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-24
 * - @see https://www.acmicpc.net/problem/17281
 * - @git
 * - @youtube
 * - @performance
 * - @category # BruteForce # Permutation # Simulation
 * - @note
 *
 */
public class Main {
    static int inning, total, turn;

    static boolean[] visited = new boolean[9];
    static int[] battingOrder = new int[9];
    static int[][] innings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inning = Integer.parseInt(br.readLine());

        innings = new int[inning][9];  // inning에 따른 정보를 기록
        for (int i = 0; i < inning; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int num = 0; num < 9; num++){
                innings[i][num] = Integer.parseInt(st.nextToken());
            }
        }

        battingOrder[3] = 1;
        permutation(0);

        System.out.println(total);
    }

    private static int play(int round){
        int bitMask = 0b0000;
        int outcnt = 0;
        int score = 0;
        while (true){
            int shift = innings[round][battingOrder[turn]-1];
            turn++;
            turn %= 9;

            if (shift == 0) {  // outcnt 3개면 라운드 끝
                if (++outcnt == 3) {
                    return score;
                }
            } else{
                bitMask |= 1;
                bitMask <<= shift;
                for (int i = 4; i < 8; i++){  // 홈런 해도 최대 4점 플러스
                    if((bitMask & (1 << i)) > 0){
                        score++;
                    }
                }
                bitMask &= 0b1111;
            }
        }
    }

    private static void game(){
        turn = 0;
        int score = 0;
        for (int i = 0; i < inning; i++){
            score += play(i);
        }
        total = Math.max(total, score);
    }

    private static void permutation(int depth){
        if (depth == battingOrder.length) {
            game();
            return;
        }

        if (depth == 3){
            permutation(depth+1);
        } else{
            for (int i = 1; i < battingOrder.length; i++){
                if(!visited[i]){  // 4번 타자는 고정
                    visited[i] = true;
                    battingOrder[depth] = i+1;
                    permutation(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}