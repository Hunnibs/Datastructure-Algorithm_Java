class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] answer = new int[nums.length];
        
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) continue;
            else {  
                if (nums[i] == nums[i+1]) {
                    answer[idx++] = nums[i] * 2;
                    nums[i+1] = 0;
                } else {
                    answer[idx++] = nums[i];
                }
            } 
        }
        
        if (nums[n-1] != 0) answer[idx] = nums[n-1];

        return answer;
    }
}