package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-10-24
 * - @see https://www.acmicpc.net/problem/23294
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */

public class BOJ_23294 {
    static StringBuilder sb = new StringBuilder();
    static int N, Q, C;
    static int curCache = 0;
    static int curIdx = 0;
    static Deque<Integer> backward = new ArrayDeque<>();
    static Deque<Integer> forward = new ArrayDeque<>();
    static int[] caches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        caches = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            caches[i] = Integer.parseInt(st.nextToken());
        }

        // main
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "A":
                    access(Integer.parseInt(st.nextToken()));
                    break;
                case "B":
                    goBack();
                    break;
                case "F":
                    goForward();
                    break;
                case "C":
                    compress();
                    break;
            }
        }

        print();
        System.out.println(sb);
    }

    private static void print() {
        sb.append(curIdx).append("\n");
        // backward
        if (backward.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            while (!backward.isEmpty()) {
                sb.append(backward.pollLast()).append(" ");
            }
            sb.append("\n");
        }

        // forward
        if (forward.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            while (!forward.isEmpty()) {
                sb.append(forward.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void compress() {
        if (backward.isEmpty()) {
            return;
        }
        int tmp = backward.pollFirst();
        int size = backward.size();
        for (int i = 0; i < size; i++) {
            if (tmp == backward.peekFirst()) {
                curCache -= caches[tmp];
            } else {
                backward.offerLast(tmp);
            }
            tmp = backward.pollFirst();
        }
        backward.offerLast(tmp);
    }

    private static void goForward() {
        if (forward.isEmpty()) {
            return;
        } else {
            backward.offerLast(curIdx);
            curIdx = forward.pollFirst();
        }
    }

    private static void goBack() {
        if (backward.isEmpty()) {
            return;
        } else {
            forward.offerFirst(curIdx);
            curIdx = backward.pollLast();
        }
    }

    private static void access(int browserNo) {
        while (!forward.isEmpty()) { // 웹 페이지에 접속한다면 앞으록 가기 페이지의 모든 페이지가 삭제된다.
            curCache -= caches[forward.poll()];
        }

        if (curIdx != 0) {  // 현재 접속중인 페이지가 있다면 뒤로가기 페이지로 넘겨준다.
            backward.offerLast(curIdx);
        }

        curCache += caches[browserNo];
        curIdx = browserNo;
        while (curCache> C) {  // 뒤로 가기 공간에 저장된 값이 c
            curCache -= caches[backward.pollFirst()];
        }
    }
}
