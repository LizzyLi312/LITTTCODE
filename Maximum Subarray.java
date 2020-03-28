class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int loc = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            loc = Math.max(loc +nums[i], nums[i]);
            max = Math.max(loc, max);
        }
        return max;
    }
}

//dp: the max sum at position i
