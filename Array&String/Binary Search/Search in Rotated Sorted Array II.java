class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return true;
            if(target == nums[left]) return true;
            if(target == nums[right]) return true;
            //if there is duplicate then left++ or right-- since duplicate is useless for the comparasion
            if(nums[left] == nums[mid]) left ++; 
            else if(nums[right] == nums[mid]) right--;
            else if(nums[left] < nums[mid]){ //it is a increasing subarray 
                if(nums[left] < target && target < nums[mid]) right = mid - 1; //check the increasing part
                else left = mid + 1;
            }
            else{ //there is a pivot inside of this subarray, [mid, right] should be an increasing array
                if(nums[mid] < target && target < nums[right]) left = mid + 1; //check the increasing part
                else right = mid - 1;
            }
        }
        return false;
    }
}
