class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        if(target < nums[left]) return 0;
        if(target > nums[right]) return nums.length;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid;
            else right = mid;
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return right;
    }
}
