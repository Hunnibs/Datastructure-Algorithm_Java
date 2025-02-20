package leetcode;

public class Day_250220 {
    class Solution {
        String unique = "";

        public String findDifferentBinaryString(String[] nums) {
            int n = nums[0].length();

            StringBuilder output = new StringBuilder();
            for (int i = 0; i <= 1; i++) {
                output.append(i);
                if (makeBinaryString(n, 1, nums, output)) break;
                output.deleteCharAt(0);
            }

            return unique;
        }

        public boolean makeBinaryString(int n, int depth, String[] nums, StringBuilder output) {
            if (n == depth) {
                String tmp = output.toString();

                boolean found = false;
                for (String num : nums) {
                    if (num.equals(tmp)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    unique = tmp;
                    return true;
                }

                return false;
            }

            boolean flag = false;
            for (int i = 0; i <= 1; i++) {
                output.append(i);

                flag = makeBinaryString(n, depth + 1, nums, output);
                if (flag) return flag;

                output.deleteCharAt(output.length() - 1);
            }

            return flag;
        }
    }
}
