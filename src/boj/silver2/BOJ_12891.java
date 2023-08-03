package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int P, S, answer = 0, start, end;
    static String input;
    static char[] DNA;
    static int[] condition = new int[4];

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        // 입력
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        input = br.readLine();
        DNA = input.toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }

        // main
        start = 0;
        end = P;
        char tmp;
        for (int j = start; j < end; j++) {
            tmp = DNA[j];
            switch(tmp) {
                case 'A':
                    condition[0]--;
                    break;
                case 'C':
                    condition[1]--;
                    break;
                case 'G':
                    condition[2]--;
                    break;
                case 'T':
                    condition[3]--;
                    break;
            }
        }

        while (true) {
            for (int x =0; x < 4; x++) {
                if (condition[x] > 0) {
                    answer--;
                    break;
                }
            }
            answer++;
            tmp = DNA[start++];
            switch(tmp) {
                case 'A':
                    condition[0]++;
                    break;
                case 'C':
                    condition[1]++;
                    break;
                case 'G':
                    condition[2]++;
                    break;
                case 'T':
                    condition[3]++;
                    break;
            }
            end++;
            if (end == S+1){
                break;
            }
            tmp = DNA[end-1];
            switch(tmp) {
                case 'A':
                    condition[0]--;
                    break;
                case 'C':
                    condition[1]--;
                    break;
                case 'G':
                    condition[2]--;
                    break;
                case 'T':
                    condition[3]--;
                    break;
            }
        }

        System.out.println(answer);
    }
}
