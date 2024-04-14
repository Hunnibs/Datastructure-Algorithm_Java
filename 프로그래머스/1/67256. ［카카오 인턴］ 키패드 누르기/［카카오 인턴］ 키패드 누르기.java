import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int curL = 10, curR = 12;
        for(int number : numbers){
            if (number == 1 || number == 4 || number == 7){
                answer.append("L");
                curL = number;
            } else if (number == 3 || number == 6 || number == 9){
                answer.append("R");
                curR = number;
            } else{  // 현재 위치 / 3 == row & 현재 위치 % 3 == col
                if (number == 0){
                    number = 11;
                }
                
                int lc = (curL-1) % 3, lr = (curL-1) / 3;
                int rc = (curR-1) % 3, rr = (curR-1) / 3;
                int nc = (number-1) % 3, nr = (number-1) / 3;
                
                if (Math.abs(lc - nc) + Math.abs(lr - nr) > Math.abs(rc - nc) + Math.abs(rr - nr)){
                    answer.append("R");
                    curR = number;
                } else if (Math.abs(lc - nc) + Math.abs(lr - nr) < Math.abs(rc - nc) + Math.abs(rr - nr)){
                    answer.append("L");
                    curL = number;
                } else{
                    if (hand.equals("right")){
                        answer.append("R");
                        curR = number;
                    } else{
                        answer.append("L");
                        curL = number;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}