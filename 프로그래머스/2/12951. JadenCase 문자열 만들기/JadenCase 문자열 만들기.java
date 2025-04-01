import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(' ');
                flag = false;
            } else {
                if (!flag) {
                    if (c >= 'a' && c <= 'z') sb.append(Character.toUpperCase(c));
                    else sb.append(c);
                    flag = true;
                } else {
                    if (c >= 'A' && c <= 'Z') sb.append(Character.toLowerCase(c));
                    else sb.append(c);
                } 
            }
        }
        
        return sb.toString();
    }
}