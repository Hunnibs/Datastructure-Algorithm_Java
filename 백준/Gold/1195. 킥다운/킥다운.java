import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2024-02-19
 * - @see https://www.acmicpc.net/problem/1195
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 2sec 128MB
 * - @category # Bitmask
 * - @note
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String g1 = br.readLine();
        String g2 = br.readLine();

        sol(g1, g2);
    }


    private static void sol(String g1, String g2) {
        int size1 = g1.length();
        int size2 = g2.length();

        BigInteger top;
        BigInteger bottom;
        int minSize = 0;
        int cnt = 0;
        // 사이즈 큰 쪽이 바텀으로
        if (size2 > size1) {
            String gear1 = makeBinary(g1, size2);
            String gear2 = makeBinary(g2, size2);
            top = new BigInteger(gear1, 2);
            bottom = new BigInteger(gear2, 2);
            minSize = size2;
            cnt = size1;
        } else {
            String gear1 = makeBinary(g1, size1);
            String gear2 = makeBinary(g2, size1);
            top = new BigInteger(gear2, 2);
            bottom = new BigInteger(gear1, 2);
            minSize = size1;
            cnt = size2;
        }

        int answer1 = checkLeft(top, bottom, minSize);
        int answer2 = checkRight(top, bottom, minSize, cnt);

        System.out.println(Math.min(answer1, answer2));
    }

    private static String makeBinary(String S, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i) - '1');
        }

        for (int i = 0; i < size - S.length(); i++) {
            sb.append('0');
        }

        return sb.toString();
    }

    private static int checkLeft(BigInteger top, BigInteger bottom, int minSize) {
        while (true) {
            if (top.and(bottom).compareTo(BigInteger.ZERO) == 0) {
                return minSize;
            }

            top = top.shiftLeft(1);
            minSize++;
        }
    }

    private static int checkRight(BigInteger top, BigInteger bottom, int minSize, int cnt) {
        int moveCnt = 0;
        while (true) {
            if (top.and(bottom).compareTo(BigInteger.ZERO) == 0) {
                if (cnt < minSize){
                    return minSize;
                } else {
                    return cnt + moveCnt;
                }
            }

            top = top.shiftRight(1);
            if (cnt == minSize) {
                moveCnt++;
            } else {
                cnt++;
            }
        }
    }
}