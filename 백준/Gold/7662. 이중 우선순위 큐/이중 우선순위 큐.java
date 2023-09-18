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
 */

public class Main {
    static PriorityQueue<Integer> minHeap;  // 기본 default 오름차순
    static PriorityQueue<Integer> maxHeap;
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

            int cnt = 0;
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

    private static void insert(int num){
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