class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') cnt++;
        }

        int answer = cnt;
        for (int i = 0; i < n - k; i++) {
            if (blocks.charAt(i) == 'W') cnt--;
            if (blocks.charAt(i+k) == 'W') cnt++;

            answer = Math.min(answer, cnt);
        }

        return answer;
    }
}