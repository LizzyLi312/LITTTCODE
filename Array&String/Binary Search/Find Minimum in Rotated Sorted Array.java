class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        if(nums[start] < nums[end]) return nums[start]; //means no rotation
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) return nums[mid];
            else if(nums[start] < nums[mid]) start = mid; //if that means we are in the increasing subarray 
            else end = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
}
