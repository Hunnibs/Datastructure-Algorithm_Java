class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;

        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int num1 = arr[r];
                int num2 = arr[c];
                int sum = num1 + num2;
                int len = 2;

                while(numSet.contains(sum)) {
                    len++;
                    num1 = num2;
                    num2 = sum;
                    sum = num1 + num2;
                    answer = Math.max(answer, len);
                }
            }
        }      

        return answer;
    }
}