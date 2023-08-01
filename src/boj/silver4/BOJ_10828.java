package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Deque<String> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String in = st.nextToken();
            switch (in) {
                case "push":
                    deque.add(st.nextToken());
                    break;
                case "pop":
                    if (deque.size() == 0){
                        System.out.println(-1);
                    }else {
                        System.out.println(deque.getLast());
                        deque.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.size() == 0){
                        System.out.println(1);
                    } else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (deque.size() == 0) {
                        System.out.println(-1);
                    } else{
                        System.out.println(deque.getLast());
                    }
                    break;
            }
        }
    }
}
