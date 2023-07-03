package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMaxValue {
    static int T;
    static int[] array = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int max = 0;

            for (int j = 0; j < 10; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < 10; j++) {
                max = Math.max(max, array[j]);
            }

            System.out.println("#" + Integer.toString(i+1) + " " + Integer.toString(max));
        }
    }
}
