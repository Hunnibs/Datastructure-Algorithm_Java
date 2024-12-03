/**

- @author 이병헌
- @since 12/3/2024
- @see https://www.acmicpc.net/problem/9012
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Stack
- @note

 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= test_case; t++){
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++){
                char cur = input.charAt(i);

                if (stack.isEmpty()) {
                    if (cur == ')') {
                        stack.offerLast(cur);
                        break;
                    } else stack.offerLast(cur);
                }
                else {
                    if (cur == ')') stack.pollLast();
                    else stack.offerLast(cur);
                }
            }

            if (stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }
}