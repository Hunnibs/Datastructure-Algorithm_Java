package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 9/17/2023
- @see https://www.acmicpc.net/problem/07662
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Priority Queue
- @note 
 최대힙과 최소힙을 두 개 사용
 최소힙에서 값을 뺐다면 만들어둔 임시 최대힙에 넣어주고 최대힙에서 삭제할 때 임시 최대힙을 확인해 같은 것이 힙에서 반환된다면 그 값은 이미 뺀 것으로 취급하는 방식이다.
 물론 최대힙도 마찬가지의 방법으로 생각했다.
 */

public class BOJ_07662 {
    static PriorityQueue<Integer> minHeap;  // 기본 default 오름차순
    static PriorityQueue<Integer> maxHeap; // 내림차순
    static PriorityQueue<Integer> minQ; // 기본 default 오름차순
    static PriorityQueue<Integer> maxQ;// 내림차순
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            minQ = new PriorityQueue<>();
            maxQ = new PriorityQueue<>(Comparator.reverseOrder());

            int N = Integer.parseInt(br.readLine());

            int cnt = 0;  // 입력 받은 개수 -> 삭제 명령이 들어오면 하나씩 줄여준다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("D") && cnt == 0){  // 삭제할것이 없는 경우 그냥 패스
                    continue;
                }

                switch (cmd) {
                    case "I":
                        insert(num);
                        cnt++;
                        break;
                    case "D":
                        delete(num);
                        update();
                        cnt--;
                        break;
                }
            }
            if (cnt == 0){
                sb.append("EMPTY\n");
            } else{
                sb.append(maxHeap.poll()).append(" " + minHeap.poll() + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(){
        while(!minQ.isEmpty()){
            if (minQ.peek().equals(minHeap.peek())){
                minQ.poll();
                minHeap.poll();
            } else{
                break;
            }
        }

        while(!maxQ.isEmpty()){
            if (maxQ.peek().equals(maxHeap.peek())){
                maxQ.poll();
                maxHeap.poll();
            } else{
                break;
            }
        }
    }

    private static void insert(int num){  // 두 힙 모두에 추가해준다.
        maxHeap.offer(num);
        minHeap.offer(num);
    }

    private static void delete(int num){
        if (num == -1){
            maxQ.offer(minHeap.poll());
        } else{
            minQ.offer(maxHeap.poll());
        }
    }
}
