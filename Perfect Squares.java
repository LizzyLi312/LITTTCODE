class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int val = 1; val <= n; val++){
            for(int i = 1; i * i <= val; i++){
                dp[val] = Math.min(dp[val], dp[val - i * i] + 1);
            }
        }
        return dp[n];
    }
}
