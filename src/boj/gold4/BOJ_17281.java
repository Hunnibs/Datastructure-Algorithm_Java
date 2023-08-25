package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * - @author 이병헌
 * - @since 2023-08-24
 * - @see https://www.acmicpc.net/problem/17281
 * - @git
 * - @youtube
 * - @performance
 * - @category # BruteForce # Permutation # Simulation
 * - @note
 * 타순을 4번 타자는 1번 선수로 고정해놓고 순열로 모든 경우를 구해준다.
 * 게임에 들어가서 이닝마다 현재 치는 타자의 번호를 업데이트 시켜가면서 점수를 내는 것을 계산한다.
 * 점수 내는 방식은 비트마스킹 방식을 활용
 */
public class BOJ_17281 {
    static int inning, total, turn;

    static boolean[] visited = new boolean[9];
    static int[] battingOrder = new int[9];
    static int[][] innings;
    public static void main(String[] args) throws IOException {
        PScanner sc = new PScanner(System.in);
        inning = sc.nextInt();

        innings = new int[inning][9];  // inning에 따른 정보를 기록
        for (int i = 0; i < inning; i++) {
            for (int num = 0; num < 9; num++){
                innings[i][num] = sc.nextInt();
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
                bitMask |= 1;  // 선수 진출
                bitMask <<= shift;  // 친 것만큼 모든 선수들 달리기
                for (int i = 4; i < 8; i++){  // 홈런 해도 최대 4점 플러스
                    if((bitMask & (1 << i)) > 0){  // 홈에 도달해서 나온 선수들이 있다면 점수를 추가
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

    static class PScanner {
        private final InputStreamReader in;
        private final char[] buf;
        private int len, ptr;

        public PScanner(InputStream input) {
            in = new InputStreamReader(input);
            buf = new char[8192];
        }

        public boolean hasNext() {
            consume();
            return ptr < len && buf[ptr] > ' ';
        }

        public String next() {
            consume();
            char[] cbuf = new char[16];
            char clen = 0;
            while ((cbuf[clen++] = read()) > ' ') {
                if (clen == cbuf.length)
                    cbuf = Arrays.copyOf(cbuf, clen << 2);
            }
            return new String(cbuf, 0, clen - 1);
        }

        public int nextInt() {
            consume();
            int v = 0;
            char c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do {
                v = v * 10 + c - '0';
            } while ('0' <= (c = read()) && c <= '9');
            return neg ? -v : v;
        }

        public long nextLong() {
            consume();
            long v = 0;
            char c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do {
                v = v * 10 + c - '0';
            } while ('0' <= (c = read()) && c <= '9');
            return neg ? -v : v;
        }

        private char read() {
            if (ptr == len) fill();
            return ptr < len ? buf[ptr++] : 0;
        }

        private void fill() {
            try {
                len = in.read(buf);
                ptr = 0;
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        private void consume() {
            char c;
            while ((c = read()) <= ' ' && c != 0) ;
            ptr--;
        }
    }
}
