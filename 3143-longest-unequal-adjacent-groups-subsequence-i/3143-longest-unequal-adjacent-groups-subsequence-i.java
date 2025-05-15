import java.util.*;
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();

        int prev = groups[0];
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (prev != groups[i]) {
                prev = groups[i];
                list.add(words[i]);
            }
        }

        return list;
    }
}