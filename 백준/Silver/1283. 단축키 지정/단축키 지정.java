/**

- @author 이병헌
- @since 11/27/2024
- @see https://www.acmicpc.net/problem/1283
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note
 N개 단어
 Option 목록
 1. 왼 -> 오, 단어의 첫 글자
 2. 다시 왼 -> 오 전체 탐색
 3. 단축키 X
 4. N번 반복
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < N; i++){
            String[] words = check(br.readLine(), alphabet);
            sb.append(String.join(" ", words)).append("\n");
        }

        System.out.println(sb);
    }

    private static String[] check(String word, boolean[] alphabet){

        String[] words = word.split(" ");
        // 1. 단어 첫 글자
        for(int i = 0; i < words.length; i++){
            String alpha = words[i];
            String beta = alpha.toLowerCase();
            if (!alphabet[beta.charAt(0) - 'a']){
                alphabet[beta.charAt(0) - 'a'] = true;
                words[i] = "[" + alpha.charAt(0) + "]" + alpha.substring(1);
                return words;
            }
        }

        return check2(words, alphabet);
    }

    private static String[] check2(String[] words, boolean[] alphabet){
        // 2. 두 번째 글자
        for (int i = 0; i < words.length; i++) {
            String alpha = words[i];
            String beta = alpha.toLowerCase();
            for (int j = 0; j < alpha.length(); j++) {
                if (!alphabet[beta.charAt(j) - 'a']) {
                    alphabet[beta.charAt(j) - 'a'] = true;
                    words[i] = alpha.substring(0, j) + "[" + alpha.charAt(j) + "]" + alpha.substring(j + 1);
                    return words;
                }
            }
        }

        return words;
    }
}