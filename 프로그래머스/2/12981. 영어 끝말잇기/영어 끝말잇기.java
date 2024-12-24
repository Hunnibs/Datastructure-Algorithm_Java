import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int round = 0;
        Set<String> set = new HashSet<>();
        char lastWord = words[0].charAt(0);
        while (true) {
            for (int i = 0; i < n; i++) {
                int order = round * n + i;
                
                if (order == words.length) return answer;
                
                if (words[order].charAt(0) != lastWord || set.contains(words[order])) {
                    answer[0] = i + 1;
                    answer[1] = round + 1;
                    return answer;
                } else { 
                    set.add(words[order]);
                    lastWord = words[order].charAt(words[order].length() - 1);
                }
            }
            round++;
        }
    }
}