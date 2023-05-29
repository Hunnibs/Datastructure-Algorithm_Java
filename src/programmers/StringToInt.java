package programmers;

import java.util.Scanner;

public class StringToInt {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        String s = Sc.next();

        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }
}
