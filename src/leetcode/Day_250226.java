package leetcode;

/*
    author : 병헌
    date : 2025-02-26
    url : https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
    performance : 2ms
    category : Kadane's algorithm
    note:

*/

public class Day_250226 {
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int curMax = 0;
            int curMin = 0;
            int maxSum = 0;
            int minSum = 0;

            for (int num : nums) {
                curMax = num > curMax + num ? num : curMax + num;
                curMin = num < curMin + num ? num : curMin + num;

                maxSum = curMax > maxSum ? curMax : maxSum;
                minSum = curMin < minSum ? curMin : minSum;
            }

            return minSum * (-1) < maxSum ? maxSum : minSum * (-1);
        }
    }
}
