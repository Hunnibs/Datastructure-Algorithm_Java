package boj.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023/10/15
- @see https://www.acmicpc.net/problem/1379
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Greedy
- @note */

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
        Collections.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else{
                    return o1.end - o2.end;
                }
            }
        });

        // main
        sol(lectures);
    }

    private static void sol(List<Lecture> lectures) {
        int[] answer = new int[N+1];
        PriorityQueue<Info> lectureProgram = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.end - o2.end;
            }
        });  // 강의실 추적 프로그램으로 강의가 끝나는 시간을 기록해줄 예정

        for (int i = 0; i < N; i++) {
            Lecture lecture = lectures.get(i);

            if (lectureProgram.isEmpty()){
                lectureProgram.offer(new Info(1, lecture.end));
                answer[lecture.num] = 1;
            } else{
                if (lectureProgram.peek().end <= lecture.start){
                    int num = lectureProgram.poll().num;
                    lectureProgram.offer(new Info(num, lecture.end));
                    answer[lecture.num] = num;
                } else{
                    lectureProgram.offer(new Info(lectureProgram.size()+1, lecture.end));
                    answer[lecture.num] = lectureProgram.size();
                }
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

    static class Info{
        int num, end;

        public Info(int num, int end) {
            this.num = num;
            this.end = end;
        }
    }

    static class Lecture{
        int num, start, end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
}
