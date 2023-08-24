package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023-08-24
 * - @see https://www.acmicpc.net/problem/15961
 * - @git
 * - @youtube
 * - @performance
 * - @category # Deque # BruteForce
 * - @note
 * 고를 수 있는 초밥의 가짓수는 N
 * 부분집합을 활용해서 나올 수 있는 초밥의 가짓수 탐색
 * 연속해서 먹는 경우는 쿠폰 초밥 +
 * 만들어진 배열을 set에 넣어주면 중복제거
 */
public class BOJ_15961 {
    static int N, d, k, c;
    static int[] sushi, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new int[d+1];
        sushi = new int[N];
        for (int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0, subsum = 0;
        for (int i = 0; i < k; i++) {
            if (visited[sushi[i]] == 0){
                subsum += 1;
            }
            visited[sushi[i]] += 1;
        }

        for (int start = 0 , end = k; start < N; start++, end++){
            if (answer == k+1){  // 종료조건
                break;
            } else{
                visited[sushi[start % N]] -= 1;
                if (visited[sushi[start % N]] == 0){
                    subsum -= 1;
                }

                if (visited[sushi[end % N]] == 0){
                    subsum += 1;
                }
                visited[sushi[end % N]] += 1;

                if (visited[c] == 0){
                    answer = Math.max(answer, subsum+1);
                } else{
                    answer = Math.max(answer, subsum);
                }
            }
        }

        System.out.println(answer);
    }
}
