package swea;
/**

 @author 이병헌
 @since 2023. 8. 12.
 @see https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AV18_yw6I9MCFAZN&categoryId=AYnnOdjq4TwDFARi&categoryType=BATTLE&battleMainPageIndex=
 @youtube
 @performance
 @category # BitMasking
 @note
 0과 주어진 숫자의 각 자릿수들을 (1 << 각 자릿수)로 or 연산을 진행한다. 조건은
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class insomniaTreatment {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int total = (1 << 10) - 1;
        for (int test_case = 1; test_case <= T; test_case++) {
            int visited = 0;
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());

            while(visited != total){
                cnt++;
                char[] nums = String.valueOf(N * cnt).toCharArray();
                for(char num : nums){
                    int numTmp = num - '0';
                    visited = visited | (1 << numTmp);
                }
            }

            sb.append("#").append(test_case).append(" ").append(N * cnt).append("\n");
        }
        System.out.println(sb);
    }
}
