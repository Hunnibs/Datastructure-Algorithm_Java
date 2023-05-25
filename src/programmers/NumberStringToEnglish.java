package programmers;

import java.util.Scanner;

public class NumberStringToEnglish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int answer = 0;

        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++){
            if (s.contains(numbers[i])) {
                s = s.replace(numbers[i], Integer.toString(i));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
