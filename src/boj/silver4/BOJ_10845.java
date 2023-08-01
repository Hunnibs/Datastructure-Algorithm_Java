package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String in = st.nextToken();
            switch (in) {
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (deque.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getFirst());
                        deque.removeFirst();
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.size() == 0) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (deque.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getFirst());
                    }
                    break;
                case "back":
                    if (deque.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getLast());
                    }
                    break;
            }
        }
    }
}
