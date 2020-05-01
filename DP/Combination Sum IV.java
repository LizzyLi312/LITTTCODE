class Solution {
    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int n : nums){
                if(i >= n) dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}
