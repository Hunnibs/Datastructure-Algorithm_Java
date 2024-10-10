/**

- @author 이병헌
- @since 10/10/2024
- @see https://www.acmicpc.net/problem/25192
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Hash
- @note

 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hello = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < N; i++){
            String in = br.readLine();
            if (in.equals("ENTER")) {
                sum += hello.size();
                hello = new HashMap<>();
                continue;
            }

            hello.put(in, 1);
        }
        sum += hello.size();

        System.out.println(sum);
    }
}