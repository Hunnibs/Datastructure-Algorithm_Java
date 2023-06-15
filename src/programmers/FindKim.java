package programmers;

import java.util.Scanner;

public class FindKim {
    public String solution(String[] seoul){
        String answer = "";

        for(int i = 0; i < seoul.length; i++){
            if (seoul[i].equals("Kim")){
                answer = "김서방은 " + i+ "에 있다";
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String seoul[] = {"Kim", "Lee"};

        FindKim kim = new FindKim();
        System.out.println(kim.solution(seoul));
    }
}
