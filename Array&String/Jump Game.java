class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int step = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i > step) return false; //means cannot reach it 
            step = Math.max(step, nums[i] + i); //every time choose the default step to take
        }
        return true;
    }
}
