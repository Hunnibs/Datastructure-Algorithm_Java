package programmers;

import java.util.Scanner;

public class HidePhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phone_number = sc.next();
        char hide_number[] = new char[phone_number.length()];

        for(int i = 0; i < phone_number.length(); i++){
            char num = phone_number.charAt(i);

            if (i < phone_number.length()-4){
                hide_number[i] = '*';
            }
            else{
                hide_number[i] = num;
            }
        }

        String answer = new String (hide_number);
        System.out.println(answer);
    }
}
