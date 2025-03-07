// find the median by using quick select, finding the smallest k / 2
class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int med = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - med);
        }
        return res;
    }

    private int quickSelect(int[] nums, int left, int right, int k) { // find a pivot and compare the pivot's index with k
        if (left == right) return nums[left];

        int pivot = left + (right - left) / 2;

        pivot = partition(nums, left, right, pivot); 

        if (pivot == k) return nums[k];
        else if (pivot < k) return quickSelect(nums, pivot + 1, right, k);
        return quickSelect(nums, left, pivot - 1, k);
    }

    private int partition(int[] nums, int left, int right, int p) {
        int pivot = nums[p];

        swap(nums, p, right);
        
        int j = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot) swap(nums, i, j++);
        }
        return j - 1;
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
