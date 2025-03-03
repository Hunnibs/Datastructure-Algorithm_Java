class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] nums : nums1) {
            sum(nums, map);
        }

        for (int[] nums : nums2) { 
            sum(nums, map);
        }

        int[][] answer = new int[map.size()][2];
        Set<Integer> keySets = map.keySet();
        int idx = 0;
        for (int id : keySets) {
            answer[idx][0] = id;
            answer[idx][1] = map.get(id);
            idx++;
        }

        return answer;
    }

    private void sum(int[] nums, Map<Integer, Integer> map) {
        int id = nums[0];
        int value = nums[1];

        if (map.containsKey(id)) {
            map.put(id, map.get(id) + value);
        } else {
            map.put(id, value);
        }
    }
}