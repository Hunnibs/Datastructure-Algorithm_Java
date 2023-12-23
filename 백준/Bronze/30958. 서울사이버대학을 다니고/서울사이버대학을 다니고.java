import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] num = new int[26];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) - 'a' <= 26 && S.charAt(i) - 'a' >= 0){
                num[S.charAt(i) - 'a']++;
            }
        }

        System.out.println(Arrays.stream(num).max().getAsInt());
    }
}