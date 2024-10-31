/**
 * - @author 이병헌
 * - @since 10/30/2024
 * - @see https://www.acmicpc.net/problem/1253
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 * 1. 조합 + Hash 자료구조
 * 조합 계산 후 포함 여부 확인 시간 복잡도 O(N^3)
 * HashSet 사용 시 O(N^2)
 * 2초 제한 -> 최악의 경우 2000 * 1999 / 2 -> 8_000_000
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else {
                map.put(num, 1);
                map2.put(num, false);
            }
            array[idx++] = num;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                int sum = array[i] + array[j];
                if (map.containsKey(sum)) {
                    if (map.get(sum).equals(2) && (array[i] == 0 && array[j] == 0)) continue;
                    if (map.get(sum).equals(1) && (array[i] == sum || array[j] == sum)) continue;

                    if (!map2.get(sum)){
                        answer += map.get(sum);
                        map2.put(sum, true);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}