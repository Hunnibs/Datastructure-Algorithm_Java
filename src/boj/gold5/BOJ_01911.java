package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 2023/10/08
- @see https://www.acmicpc.net/problem/1911
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category #
- @note */

public class BOJ_01911 {
    static class Info{
        int start, end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // main
        System.out.println(search(pq));
    }

    private static int search(PriorityQueue<Info> pq){
        int current = 0, answer = 0;
        int start, end;
        while(!pq.isEmpty()){
            Info info = pq.poll();
            start = info.start;
            end = info.end;

            if(current < start){
                current = start;
            }
            while(isIn(start, end, current)){
                current += L;
                answer++;
            }
        }

        return answer;
    }

    private static boolean isIn(int start, int end, int current){
        return current >= start && current < end;
    }
}
