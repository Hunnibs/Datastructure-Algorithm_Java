package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**

@author 이병헌
@since 2023. 08. 13
@see https://www.acmicpc.net/problem/11286
@git
@youtube
@performance
@category # Heap
@note
 우선순위 큐를 활용해서 힙의 특성을 사용한다.
 */

public class BOJ_11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<Integer> negative = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if (input != 0){  // 조건에 따라 0이 아닌 경우에만 힙에 넣어준다.
                if (input < 0){  // 이 때 음수가 입력으로 들어온 경우에 절대값을 힙에 넣어주고 음수 값은 따로 리스트에 보관해준다.
                    negative.add(input);
                }
                pq.add(Math.abs(input));
            } else{
                if (pq.isEmpty()){  // 힙이 비어있다면 0을 출력해준다는 조건
                    sb.append(0).append("\n");
                } else {
                    int output = pq.poll();
                    if (negative.contains(output * (-1))) {  // 힙에서 뺐을 때 값이 여러 개라면 음수를 출력해야하므로 negative 리스트에 넣어줬던 값을 확인해준다.
                        negative.remove(negative.indexOf(output * (-1)));
                        sb.append(output * (-1)).append("\n");
                    } else {
                        sb.append(output).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
