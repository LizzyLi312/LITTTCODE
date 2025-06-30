class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > 0 && mid < nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid; 
            if (nums[mid + 1] > nums[mid]) l = mid + 1; // mid + 1 will not exceed boundary since l will always smaller than r
            else r = mid;
        }
        return r;
    }
}
