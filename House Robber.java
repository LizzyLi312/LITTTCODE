class Solution {
    public int rob(int[] nums) {
        int max = 0;
        if(nums == null || nums.length == 0) return max;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];  //keep the maximum till house i
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = dp[i - 2] + nums[i];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[nums.length - 1];
        //using 2 variable
        int max = 0;
        if(nums == null || nums.length == 0) return max;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int ppre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        max = pre;
        for(int i = 2; i < nums.length; i++){
            max = ppre + nums[i];
            max = Math.max(max, pre);
            ppre = pre;
            pre = max;
        }
        return max;
}

//time: O(n)    space:O(n)
//the time could be O(1), keep 2 variable
