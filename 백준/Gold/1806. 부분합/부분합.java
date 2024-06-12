import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, start = 0, end = 0;
        int length = Integer.MAX_VALUE;
        while(start <= end && end <= N){
            if (sum < S){
                sum += nums[end++];
            } else{
                length = Math.min(length, end - start);
                sum -= nums[start++];
            }
        }

        int answer = length == Integer.MAX_VALUE ? 0 : length;
        System.out.print(answer);
    }
}