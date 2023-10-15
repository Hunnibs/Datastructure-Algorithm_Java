package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023/10/15
 * - @see https://www.acmicpc.net/problem/1379
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance
 * - @category # Greedy
 * - @note
 */

public class BOJ_01379 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lectures, new Comparator<Lecture>() {  // 시작시간이 같을 때는 끝나는 시간이 먼저인 강의를 우선순위로 정렬한다.
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        // main
        sol(lectures);
    }

    private static void sol(List<Lecture> lectures) {
        int[] answer = new int[N + 1];
        PriorityQueue<Info> lectureProgram = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.end - o2.end;
            }
        });  // 강의실 추적 프로그램으로 강의가 끝나는 시간을 기록해줄 예정, 우선순위는 강의가 끝나는 시간

        for (int i = 0; i < N; i++) {
            Lecture lecture = lectures.get(i);  // 가장 먼저 시작하는 강의부터

            if (!lectureProgram.isEmpty() && lectureProgram.peek().end <= lecture.start) {
                int num = lectureProgram.poll().num;
                lectureProgram.offer(new Info(num, lecture.end));
                answer[lecture.num] = num;
            } else {
                lectureProgram.offer(new Info(lectureProgram.size() + 1, lecture.end));
                answer[lecture.num] = lectureProgram.size();
            }

        }

        printAnswer(answer, lectureProgram.size());
    }

    private static void printAnswer(int[] answer, int size) {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int N;

    static class Info {  // 강의실 사용자를 추적하기 위한 클래스, 어떤 강의실에 몇 시까지 강의하는지가 기록된다.
        int num, end;

        public Info(int num, int end) {
            this.num = num;
            this.end = end;
        }
    }

    static class Lecture {  // 주어지는 강의에 대한 정보를 기록
        int num, start, end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
}
