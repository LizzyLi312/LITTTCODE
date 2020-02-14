class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;  //base case
        for(int i = 1; i <= amount; i++) dp[i] = amount + 1; 
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){  //for one amout value, try every coin value, dp[i] will be the smallest value eventually
                if(coin <= i) 
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  //induction rule
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
