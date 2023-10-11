package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.util.Arrays.*;

/**

- @author 이병헌
- @since
- @see
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class TreeHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] trees = new Integer[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
            }
            sort(trees, Collections.reverseOrder());
            int maxTree = trees[0];
            int answer = 0;
            int start = 1;
            int end = trees.length;
            out: while (true){
//                System.out.println(Arrays.toString(trees));
                while (trees[start] == maxTree){
                    start++;
                    if (start == end){
                        break out;
                    }
                }

                answer++;
                outer: if (answer % 2 == 1){  // 홀수날
                    for (int i = start; i < end; i++) {
                        if (trees[i]+1 == maxTree){
                            trees[i]++;
                            break outer;
                        }

                        if (start != end-1 && trees[i] % 2 == 1){
                            trees[i]++;
                            break outer;
                        }
                    }

                    if (start == end-1 && trees[start]+2 == maxTree){

                    } else{
                        trees[start]++;
                    }
                } else {  // 짝수날
                    for (int i = start; i < end; i++) {
                        if (trees[i] + 2 == maxTree){
                            trees[i]+=2;
                            break outer;
                        }

                        if (trees[i] + 2 <= maxTree && trees[i] % 2 == 0){
                            trees[i] += 2;
                            break outer;
                        }
                    }

                    for (int i = start; i < end; i++) {
                        if (trees[i] + 2 <= maxTree){
                            trees[i] += 2;
                            break;
                        }
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
