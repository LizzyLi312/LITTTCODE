class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            int maxval = 0; //to store the max seq before i 
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) maxval = Math.max(dp[j], maxval);
            }
            dp[i] = maxval + 1; 
            res = Math.max(res, dp[i]); 
        }
        return res;
    }
}
