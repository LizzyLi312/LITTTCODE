class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++){  //visit each number in the array
            dp[i] = 1;
            for(int j = 0; j < i; j++){  //this loop starts when i > j! so the nums[i] is ahead of nums[j]
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);  //update dp[i]. In tnis way we can find all the nums that are smaller than nums[j]
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
