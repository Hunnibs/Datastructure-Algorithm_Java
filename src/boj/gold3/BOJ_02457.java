package boj.gold3;

/**

- @author 이병헌
- @since 1/14/2025
- @see https://www.acmicpc.net/problem/2457
- @git https://github.com/Hunnibs
- @youtube
- @performance 1sec 197MB
- @category # Greedy
- @note

 1. 월은 그대로 일은 한자릿수에 0을 붙여 숫자로 저장 6월 9일이면 609로 저장
 2. 이미 심은 꽃이 시들기 전에 다시 심어야한다.

 꽃을 시작일로 정렬해서 가장 빠른 것부터 심는다.
 301 이전 시작(가장 길게 가는 꽃 심기) -> 가장 길게 가는 꽃 기준 다시 기간 안에 심어야한다. (두개의 케이스 분류)

 edge case
 월말에서 월초 넘어가는 시점 비교식 주의
 */

import java.util.*;
import java.io.*;

public class BOJ_02457 {
    private static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int blossomStart = 301;
    private static final int blossomEnd = 1130;

    private static class Flower{
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static int solution(int N, PriorityQueue<Flower> flowers) {
        Deque<Flower> stack = new ArrayDeque<>();  // 꽃 심기 스케줄러 역할

        while (!flowers.isEmpty()) {
            if (!stack.isEmpty() && stack.peekLast().end > blossomEnd) break;

            Flower flower = flowers.poll();
            int start = flower.start;
            int end = flower.end;

            // case 1: 꽃 만개 시작일이 301보다 작은 경우
            if (start <= blossomStart) {
                if (stack.isEmpty()) stack.offerLast(flower);
                else {
                    if (stack.peekLast().end < end) {
                        stack.pollLast();
                        stack.offerLast(flower);
                    }
                }
            } else {  // case 2: 꽃 스케줄러 본격 시작
                if (stack.isEmpty()) return 0;  // 301보다 큰걸 제일 먼저 심는다면 이미 공주는 화가 났다.

                Flower tmp = new Flower(0, 0);
                while(!stack.isEmpty()) {
                    Flower tmpFlower = stack.peekLast();
                    if (end <= tmpFlower.end || start > tmpFlower.end) break;  // 이미 심은 것보다 더 빨리 시들면 심을 필요조차 없음

                    if (start <= tmpFlower.end) {
                        if (end > tmpFlower.end)  {
                            tmp = tmpFlower;
                            stack.pollLast();
                        }
                    }
                }
                if (tmp.start != 0) {
                    stack.offerLast(tmp);
                    stack.offerLast(flower);
                }
            }
        }

//        int size = stack.size();
//        for (int i = 0; i < size; i++) {
//            System.out.println(stack.pollLast().toString());
//        }

        if (stack.peekLast().end > blossomEnd) return stack.size();
        else return 0;
//        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> flowers = new PriorityQueue<>(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if(o1.start != o2.start) return Integer.compare(o1.start, o2.start);
                else return Integer.compare(o1.end, o2.end);
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int month1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            int start = month1 * 100 + day1;
            int end = month2 * 100 + day2;
            flowers.add(new Flower(start, end));
        }

        System.out.print(solution(N, flowers));
    }
}
