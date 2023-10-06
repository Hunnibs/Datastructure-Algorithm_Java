package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023-10-05
- @see
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class TreasurePassword {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            Set<String> set = new TreeSet<>(Collections.reverseOrder());
            String pwd = br.readLine();
            sb.append(pwd).append(pwd).append(pwd).append(pwd);
            pwd = sb.toString();

            int cnt = N / 4;
            int startidx = 0;
            for (int k = 0; k < cnt; k++) {
                for (int i = 0; i < 4; i++) {
                    int left = (startidx + cnt * i);
                    int right = (startidx + cnt * i + cnt);
                    set.add(pwd.substring(left, right));
                }
                startidx++;
            }

            int idx = 1;
            for (String s : set) {
                if(idx++ == K){
                    answer.append("#" + test_case + " " + Integer.parseInt(s, 16) + "\n");
                }
            }
        }
        System.out.println(answer);
    }
}
