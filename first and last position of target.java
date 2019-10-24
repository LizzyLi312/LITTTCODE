class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        //first position 
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[] {-1, -1};  //how to new a int array, remember to use the { }
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid;
            else right = mid;
        }
        if(nums[left] == target) res[0] = left;
        else if(nums[right] == target) res[0] = right;
        //last position
        int left2 = 0;
        int right2 = nums.length - 1;
        while(left2 + 1 < right2){
            int mid2 = left2 + (right2 - left2) / 2;
            if(nums[mid2] <= target) left2 = mid2;
            else right2 = mid2;
        }
        if(nums[right2] == target) res[1] = right2;
        else if(nums[left2] == target) res[1] = left2;
        return res;
    }
}

//better, cleaner version 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};  //how to return a new int array without declaration
        return new int[] {first(nums, target), last(nums, target)};
    }
    private int first(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[] {-1, -1};
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid;
            else right = mid;
        }
        if(nums[left] == target) return left;
        else return (nums[right] == target) ? right : -1;
    }
    private int last(int[] nums, int target){
        int left2 = 0;
        int right2 = nums.length - 1;
        while(left2 + 1 < right2){
            int mid2 = left2 + (right2 - left2) / 2;
            if(nums[mid2] <= target) left2 = mid2;  //Hi, here
            else right2 = mid2;
        }
        if(nums[right2] == target) return right2;
        else return (nums[left2] == target) ? left2 : -1;
    }
}

//Using Binary Search. #3
//the first position part could re-use the first bad version code. 
//For the last position part, the code does not have a lot of change. I only changed the line 52, the condition of the if-else 
//chunk. Cause we need to search the last position, so we need to move right-ward to skip all the target in the front.
//n
