package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/09/09
- @see https://www.acmicpc.net/problem/BOJ_01655
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Heap
- @note
 힙을 두 개 만들어서 각각 오름차순과 내림차순으로 정렬을 시행
 계속해서 두 힙의 길이 차이를 1 이상이 나지 않도록 유지해주면서 결과값을 찾아준다.
 */

public class BOJ_01655  {
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> smallSide = new PriorityQueue<>(new Comparator<Integer>() {  // 내림차순 정렬
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    static PriorityQueue<Integer> largeSide = new PriorityQueue<>(new Comparator<Integer>() {  // 오름차순 정렬
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // main
        // init - 초기화 과정이 필요, 첫 두 수를 받아서 각각 힙에 넣어준다.
        int first = Integer.parseInt(br.readLine());
        sb.append(first).append("\n");  // 처음 넣은 숫자는 무조건 중간값

        int second = Integer.parseInt(br.readLine());
        sb.append(Math.min(first, second)).append("\n");  // 두 번째로 넣은 숫자는 첫번 째 수와 비교해서 더 작은 값을 넣어준다.
        smallSide.offer(Math.min(first,second));
        largeSide.offer(Math.max(first,second));

        // main logic
        for (int i = 0; i < N - 2; i++) {
            int current = Integer.parseInt(br.readLine());
            push(current);
            update();
            findMiddle();
        }
        System.out.println(sb);
    }
    private static void findMiddle(){  // 힙의 길이가 더 긴 쪽이 중간값을 가지고 있다는 뜻이다.
        if(smallSide.size() < largeSide.size()){
            sb.append(largeSide.peek()).append("\n");
        } else{  // 힙의 길이가 같을 때는 더 작은 수를 출력해야하는 조건 때문에 내림차순 정렬로 되어있는 쪽에서 꺼내온다.
            sb.append(smallSide.peek()).append("\n");
        }
    }

    private static void update(){
        if (Math.abs(smallSide.size() - largeSide.size()) > 1){  // 두 힙의 길이 차이가 2인 경우 1이 되도록 길이 차이를 맞춰준다.
            if (smallSide.size() > largeSide.size()){
                largeSide.offer(smallSide.poll());
            } else{
                smallSide.offer(largeSide.poll());
            }
        }
    }

    private static void push(int current){
        if(smallSide.peek() > current){  // 내림차순으로 정렬되어있는 값들보다 작은 경우 그 쪽으로 push
            smallSide.offer(current);
        } else if(largeSide.peek() < current){  // 오름차순으로 정렬되어있는 값들보다 큰 경우 그 쪽으로 push
            largeSide.offer(current);
        } else{  // 두 힙의 최소 최대의 사잇값이라면 힙의 사이즈가 더 작은 쪽으로 넣어준다.
            if (largeSide.size() < smallSide.size()){
                largeSide.offer(current);
            } else{  // 두 사이즈가 같을 때에도 내림차순으로 정렬된 힙으로 넣어준다.
                smallSide.offer(current);
            }
        }
    }
}
