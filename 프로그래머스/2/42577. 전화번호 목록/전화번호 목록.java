import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            set.remove(phone);
            int n = phone.length();
            for (int i = 1; i <= n; i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
            set.add(phone);
        }
        
        return answer;
    }
}