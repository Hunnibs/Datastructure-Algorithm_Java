package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int d = y - x - 2;

            if (d == 0) {
                System.out.println(2);  // 행성 간 거리가 2인 경우
                continue;
            }

            int l = 1;
            int r = 1;
            int a = 2;
            while (true){
                if (l + r + 2 <= d) {
                    l++;
                    r++;
                    a += 2;
                    d -= (l + r + 2);
                } else {
                    if (l + 1 == d || l == d || l -1 == d){
                        a++;
                        break;
                    } else{
                        a += 2;
                        break;
                    }
                }
            }

            System.out.println(a);
        }
    }
}
