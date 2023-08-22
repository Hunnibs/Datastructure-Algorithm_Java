package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-22
 * - @see  https://www.acmicpc.net/problem/1759
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * 암호문으로 주어진 철자를 정렬한다.
 * C개 중 L 개를 뽑는다. -> combination 사용 예정
 * {a, e, i, o, u}에 포함되면 모음 변수 ++, 아니라면 자음 변수 ++
 * 기저 조건 도달했을 때 모음 변수 >= 1 && 자음 변수 >= 2가 아니라면 패쓰
 */
public class BOJ_01759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String v = "aeiou";
    static int L, C, consonant, vowel;
    static String[] alphabets;
    static String[] password;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        password = new String[L];
        alphabets = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);
        combination(0, 0);
        System.out.println(sb);
    }

    private static void combination(int start, int depth){
        if (depth == L) {
            if (vowel >= 1 && consonant >= 2){
                for (int i = 0; i < L; i++){
                    sb.append(password[i]);
                }
                sb.append("\n");
            }
            return;
        } else{
            for (int i = start; i < C; i++){
                if (v.contains(alphabets[i])){
                    vowel++;
                    password[depth] = alphabets[i];
                    combination(i+1, depth+1);
                    vowel--;
                } else{
                    consonant++;
                    password[depth] = alphabets[i];
                    combination(i+1, depth+1);
                    consonant--;
                }
            }
        }
    }
}
