// find the median by using quick select, finding the smallest k / 2
class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int med = quickSelect(nums, 0, nums.length - 1, nums.length / 2 + 1);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - med);
        }
        return res;
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) return nums[right];
        int pivot = nums[left + (right - left) / 2], i = left - 1, j = right + 1; // need to cache the pivot actual value 
        while (i < j) {
            while (nums[++i] < pivot);
            while (nums[--j] > pivot);
            if (i < j) swap(nums, i, j);
        }
        int cnt = j - left + 1;
        if (k <= cnt) return quickSelect(nums, left, j, k);
        return quickSelect(nums, j + 1, right, k - cnt);
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
// solution2 mahattan distance 
class Solution {
    public int minMoves2(int[] nums) { 
        // odd - dis = (x - a) + (x - b) + (c - c) + (d - x) + (e - x) = (d + e) - (a + b)
        // even - dis = (x - a) + ((c + b) / 2 - b) + (c - (c + b) / 2) + (d - x) = (c + d) - (a + b)
        if (nums == null || nums.length <= 1) return 0;

        int left = 0, right = nums.length - 1;
        int res = 0;
        Arrays.sort(nums);
        while (left < right) {
            res += nums[right--] - nums[left++]; //0,3 -> 1, 2 -> 2, 3|| 0, 4 -> 1, 3 -> 2, 2
        }
        return res;
    }
}
