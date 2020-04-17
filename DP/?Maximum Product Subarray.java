class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0]; //position[i] max value so far
        int minL = nums[0], maxL = nums[0];
        for(int i = 1; i < nums.length; i++){
            int copy = minL; //since we need the minL and maxL from last time. if we update maxL first we also need to cache the maxL from last time too
            minL = Math.min(Math.min(minL * nums[i], maxL * nums[i]), nums[i]); //for the negative integers. e.g.[-2,3,-4]
            maxL = Math.max(Math.max(copy * nums[i], maxL * nums[i]), nums[i]);
            max = Math.max(max, maxL);
        }
        return max;
    }
}
