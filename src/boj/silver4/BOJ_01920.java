package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 08. 13
@see https://www.acmicpc.net/problem/1920
@git
@youtube
@performance
@category # 
@note
100000짜리 배열을 만들고 해당 숫자에 해당하는 값이 true이면 1 false면 0을 출력
 메모리는 많이 쓰지만 탐색 시간이 빠르기 때문에 사용
 -> 문제를 잘못 읽었다. 정수의 범위는 int 범위와 같다
 
 N의 개수와 M의 개수가 100000이므로 탐색시간을 줄이는 것이 시간 내에 들어오는 것에 대한 관건이 될 것 같다. 그래서 이진탐색을 활용해서 문제를 풀기로 함

 */

public class BOJ_01920 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            binarySearch(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    private static void binarySearch(int target){
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                sb.append(1).append("\n");
                return;
            }

            if (nums[mid] < target){
                left = mid+1;
            } else if(nums[mid] > target){
                right = mid-1;
            }
        }

        sb.append(0).append("\n");
    }
}
