class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        if(nums[0] < nums[nums.length - 1]) return nums[0];
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) return nums[mid];
            else if(nums[mid] == nums[left]) left++; //these condition are mutually exclusive
            else if(nums[mid] == nums[right]) right--;
            else if(nums[left] < nums[mid]) left = mid;
            else right = mid;
        }
        return Math.min(nums[left], nums[right]);
    }
}
