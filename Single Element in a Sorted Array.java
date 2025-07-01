// solution1 
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}

// solution2 binary search: using idx mod 2 to tell the single number is on which side 
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && mid < nums.length - 1 && nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) return nums[mid]; // the unique number
          
            if (mid % 2 == 0 && nums[mid + 1] == nums[mid]) l = mid + 1; // the single number is on the right side 
            else if (mid % 2 != 0 && nums[mid - 1] == nums[mid]) l = mid + 1; // the single number is on the right side 
            else r = mid;
        }
        return nums[r];
    }
}
