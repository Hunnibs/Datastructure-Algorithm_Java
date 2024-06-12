package programmers;
import java.util.*;
public class Phoneketmon {

    class Solution {
        public int solution(int[] nums) {
            int answer = nums.length / 2;

            HashMap map = new HashMap<>();
            for(int num : nums){
                map.put(num, 1);
            }

            if (map.size() < answer){
                answer = map.size();
            }

            return answer;
        }
    }
}
