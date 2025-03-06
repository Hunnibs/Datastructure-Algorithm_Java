class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid[0].length;
        int[] number = new int[n+1];

        for (int[] nums : grid) {
            for (int num : nums) {
                number[num]++;
            }
        } 

        int[] answer = new int[2];
        for (int i = 1; i <= n; i++) {
            if (number[i] == 0) answer[1] = i;
            if (number[i] == 2) answer[0] = i;
        }

        return answer;
    }
}