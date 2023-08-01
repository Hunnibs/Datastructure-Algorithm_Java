package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MostFrequent {
    static int T;
    static int[] arr;

    public static void main(String arg[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            arr = new int[101];
            Arrays.fill(arr, 0);
            for (int i = 0; i < 1000; i++) {
                arr[Integer.parseInt(st.nextToken())] += 1;
            }

            int max = 0;
            int idx = 0;
            for (int i = 0; i <= 100; i++) {
                if (arr[i] >= max) {
                    max = arr[i];
                    idx = i;
                }
            }

            System.out.println("#" + Integer.toString(test_case) + " " + Integer.toString(idx));
        }
    }
}
