package playground;

import java.util.*;
import java.io.*;

public class RamdomTimeResolver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> days = new HashMap<>();
        days.put("월요일", 0);
        days.put("화요일", 1);
        days.put("수요일", 2);
        days.put("목요일", 3);
        days.put("금요일", 4);
        days.put("토요일", 5);
        days.put("일요일", 6);

        Queue<Time> impossibleTime = new ArrayDeque<>();
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(input);

            int day = days.get(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            impossibleTime.offer(new Time(day, startTime, endTime));
        }

        boolean[][] timeTable = makeTimeTable(impossibleTime);

        while(true) {
            System.out.println("회의 시간 입력");
            int time = Integer.parseInt(br.readLine());
            Time recommendTime = meetingTimeSelect(timeTable, time);

            System.out.println(dayConverter(days, recommendTime.day) + " " + recommendTime.startTime + " " + recommendTime.endTime);

            System.out.println("재추천? Y or N");
            String select = br.readLine().toLowerCase();

            if(select.equals("y")) continue;
            else break;
        }
    }

    private static Time meetingTimeSelect(boolean[][] timeTable, int time) {
        Random random = new Random();
        int randomDay = random.nextInt(6);

        while (true) {
            boolean flag = false;
            int randomStartTime = random.nextInt(22);
            if (randomStartTime < 9) continue;

            for (int i = randomStartTime; i < randomStartTime + time; i++) {
                if (timeTable[randomDay][i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            else return new Time(randomDay, randomStartTime, randomStartTime+time);
        }
    }

    private static boolean[][] makeTimeTable(Queue<Time> impossibleTime) {
        boolean[][] timeTable = new boolean[7][25];

        while (!impossibleTime.isEmpty()) {
            Time next = impossibleTime.poll();

            for (int i = next.startTime; i <= next.endTime; i++) {
                timeTable[next.day][i] = true;
            }
        }

        return timeTable;
    }

    private static String dayConverter(HashMap<String, Integer> days, int day) {
        for (String key : days.keySet()) {
            if (days.get(key) == day) return key;
        }

        return "error";
    }

    private static class Time{
        int day;
        int startTime;
        int endTime;

        public Time(int day, int startTime, int endTime) {
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
