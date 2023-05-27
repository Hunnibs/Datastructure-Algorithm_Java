package programmers;

import java.util.Arrays;
import java.util.Scanner;



public class CountUp {
    public static int[] Add(int[] answer, int num){
        int newAnswer[] = new int[answer.length+1];

        for (int i = 0; i < answer.length; i++){
            newAnswer[i] = answer[i];
        }

        newAnswer[answer.length] = num;

        return newAnswer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] answer = {};

        for (int num = start; num <= end; num++) {
            answer = Add(answer, num);
        }

        System.out.println(Arrays.toString(answer));
    }
}
