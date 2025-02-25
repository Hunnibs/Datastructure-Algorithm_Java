package leetcode;

public class Day_250225 {
    class Solution {
        private final int MODULO = (int) Math.pow(10, 9) + 7;

        public int numOfSubarrays(int[] arr) {
            int answer = 0;
            int oddCount = 0;
            int evenCount = 1;
            int prefixSum = 0;
            for (int num : arr) {
                prefixSum += num;
                if (prefixSum % 2 == 0) {
                    evenCount++;
                    answer += oddCount;
                } else {
                    oddCount++;
                    answer += evenCount;
                }

                answer %= MODULO;
            }

            return answer;
        }
    }
}
