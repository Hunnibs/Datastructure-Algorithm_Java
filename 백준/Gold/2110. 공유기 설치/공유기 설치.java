import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023/09/28
 * - @see https://www.acmicpc.net/problem/2110
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Dynamic Programming
 * - @note
 * 1. C 길이의 리스트를 미리 세팅해놓는다
 * 2. 수가 들어왔을 때
 */

public class Main {
    static int N, C;
    static List<Integer> houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //main
        houses = new ArrayList<>();
        int left = 0, right = 0, result = 0;
        for (int i = 0; i < N; i++) {
            int house = Integer.parseInt(br.readLine());
            houses.add(house);
        }

        Collections.sort(houses);
        left = 1;
        right = houses.get(N-1) - houses.get(0);

        while (left <= right){
            int mid = (left + right) / 2;

            if (sol(mid)){
                right = mid-1;
            } else{
                result = Math.max(result, mid);
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }

    private static boolean sol(int distance){
        int cnt = 1, idx = 0;
        for (int i = 1; i < N; i++) {
            if (houses.get(i) - houses.get(idx) >= distance){
                idx = i;
                cnt++;
            }
        }
        if (cnt >= C){
            return false;
        } else{
            return true;
        }
    }
}