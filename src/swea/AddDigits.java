package swea;

import java.util.Scanner;

public class AddDigits {
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        num = sc.nextInt();

        for (int i = 1; i < 5; i++) {
            int tmp = num % 10;
            num = (num-tmp) / 10;
            sum += tmp;
        }
        System.out.println(sum);
    }
}
