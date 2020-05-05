class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 2) return nums.length;
        int slow = 2, fast = 2;
        for(fast = 2; fast < nums.length; fast++){
            if(nums[slow - 2] != nums[fast]) nums[slow++] = nums[fast]; //compares it to slow - 2!!
        }
        return slow;
    }
}
