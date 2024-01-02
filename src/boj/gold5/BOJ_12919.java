package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String T = br.readLine();
        sb.append(T);

        System.out.println(equalCheck(sb, S));
    }

    private static int equalCheck(StringBuilder sb, String S) {
        if (sb.toString().length() == S.length()){  // 기저조건
            if (sb.toString().equals(S)){
                return 1;
            } else{
                return 0;
            }
        }

        int result = 0;
        if (sb.charAt(sb.length()-1) == 'A'){
            result = equalCheck(calculate1(sb), S) == 1 ? 1 : 0;
            original1(sb);
            if (result == 1){
                return result;
            }
        }

        if (sb.charAt(0) == 'B'){
            result = equalCheck(calculate2(sb), S) == 1 ? 1 : 0;
            original2(sb);
            if (result == 1){
                return result;
            }
        }

        return 0;
    }

    private static StringBuilder calculate1(StringBuilder sb){
        return sb.deleteCharAt(sb.length()-1);
    }

    private static StringBuilder original1(StringBuilder sb) { return sb.append('A'); }

    private static StringBuilder calculate2(StringBuilder sb){
        return sb.reverse().deleteCharAt(sb.length()-1);
    }

    private static StringBuilder original2(StringBuilder sb) { return sb.append('B').reverse(); }
}
