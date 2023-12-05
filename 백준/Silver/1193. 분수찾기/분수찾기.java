import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/4/23
- @see https://www.acmicpc.net/problem/1193
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Math
- @note
 r+c : 짝수 => 위에서 아래 대각
 r+c : 홀수 => 아래에서 위 대각
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int r = 1, c = 1;
        for (int i = 1; i < N; i++) {
            if ((r + c) % 2 == 0){
                if(r == 1) {
                    c++;
                } else{
                    r--;
                    c++;
                }
            } else{
                if (c == 1){
                    r++;
                } else{
                    r++;
                    c--;
                }
            }
        }
        System.out.println(r + "/" + c);
    }
}