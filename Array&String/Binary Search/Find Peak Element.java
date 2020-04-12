class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid; //peak
            else if(mid - 1 >= 0 && nums[mid] > nums[mid - 1]) start = mid; //we are on the increasing part. so go futher to get to the peak
            else end = mid;
        }
        return nums[start] > nums[end] ? start : end;
    }
}
