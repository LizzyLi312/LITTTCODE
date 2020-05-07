class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;
        int slow = 0, fast = 1;
        int max = 0;
        for(fast = 1; fast < nums.length; fast++){
            if(nums[fast] <= nums[fast - 1]){
                max = Math.max(max, fast - slow);
                slow = fast;
            }
            else continue;
        }
        max = Math.max(max, fast - slow);
        return max;
    }
}

//sliding window
