import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/1/23
- @see https://www.acmicpc.net/problem/
- @git https://github.com/Hunnibs
- @youtube
- @performance 2초, 512MB 제한
- @category # Brute Force
- @note
문자열 연산 속도를 빠르게 진행하기 위해 String이 아닌 StringBuilder를 활용
 */

public class Main {
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
        } else{
            result = equalCheck(calculate2(sb), S) == 1 ? 1 : 0;
        }

        return result;
    }

    private static StringBuilder calculate1(StringBuilder sb){
        return sb.deleteCharAt(sb.length()-1);
    }

    private static StringBuilder calculate2(StringBuilder sb){
        return sb.deleteCharAt(sb.length()-1).reverse();
    }
}