package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023/10/01
- @see https://www.acmicpc.net/problem/14891
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # bitMasking
- @note */

public class BOJ_14891 {
    static int[] gear = new int[4];
    static int[] delta = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            gear[i] = Integer.parseInt(br.readLine(), 2);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            check(gearNum, dir);
        }

        System.out.println(answer());
    }

    private static void check(int gearNum, int dir){
        int[] checked = new int[4];
        boolean[] visited = new boolean[4];
        Stack<Integer> stack = new Stack<>();

        int bit;

        checked[gearNum] = dir;
        visited[gearNum] = true;
        stack.push(gearNum);

        while(!stack.isEmpty()){
            int current = stack.pop();
            for (int i = 0; i < 2; i++) {
                int next = current + delta[i];
                if (next >= 0 && next < 4 && !visited[next]){
                    if (current < next){
                        if ((((gear[next] & (1 << 1))) >> 1) != (((gear[current] & (1 << 5))) >> 5)){
                            checked[next] = checked[current] * (-1);
                        }
                        visited[next] = true;
                        stack.push(next);
                    } else{
                        if ((((gear[current] & (1 << 1)) >> 1)) != (((gear[next] & (1 << 5)) >> 5))){
                            checked[next] = checked[current] * (-1);
                        }
                        visited[next] = true;
                        stack.push(next);
                    }
                }
            }
        }
        update(checked);
    }

    private static void update(int[] checked){
        int bit;
        for (int i = 0; i < 4; i++) {
            if (checked[i] == 1){
                bit = gear[i] & 1;
                bit = bit << 7;
                gear[i] = gear[i] >> 1;
                gear[i] = gear[i] | bit;
            } else if (checked[i] == -1){
                gear[i] = gear[i] << 1;
                if (Integer.toBinaryString(gear[i]).length() > 8) {
                    bit = gear[i] & (1 << 8);
                    bit = bit >> 8;
                    gear[i] = gear[i] | bit;
                }
                gear[i] = gear[i] & 0b11111111;
            }
        }
    }

    private static int answer(){
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if ((((gear[i] & (1 << 7))) >> 7) == 1){
                sum += (int)Math.pow(2, i);
            }
        }
        return sum;
    }
}
