class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        // find pivot - pivot should be the last element that is bigger than nums[0] since if we're looking for the 1st smaller element it would be more things to consider if the arr did not get rotated 
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] < nums[0]) r = mid - 1;
            else l = mid;
        }

        int pivot = r;

        if (target >= nums[0]) {
            l = 0;
        }
        else {
            l = pivot + 1;
            r = nums.length - 1;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return nums[r] == target ? r : -1;
    }
}
