class Solution {
    final int MOD = 10007;
    
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int m = 2 * n + 1;
        boolean[] tiles = new boolean[m];
        for (int i = 0; i < n ;i++) {
            if (tops[i] == 1) tiles[i * 2 + 1] = true;
        }
        
        int[] dp = new int[m+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= m; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            if (i % 2 == 0 && tiles[i-1]) { 
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
        }
        
        return dp[m];
    }
}