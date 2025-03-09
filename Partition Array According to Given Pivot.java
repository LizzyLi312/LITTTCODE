// stack
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length == 0) return nums;

        Stack<Integer> big = new Stack<>();
        Stack<Integer> small = new Stack<>();

        int cnt = 0;
        for (int num : nums) {
            if (num == pivot) cnt++;
            else if (num > pivot) big.push(num);
            else small.push(num);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!big.isEmpty()) nums[i] = big.pop();
            else if (cnt-- > 0) nums[i] = pivot;
            else if (!small.isEmpty()) nums[i] = small.pop();
        }
        return nums;
    }
}

// 2 pointers 
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length == 0) return nums;

        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];

        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            } 

            if (nums[j] > pivot) {
                res[right--] = nums[j];
            }
        }

        while (left <= right) {
            res[left++] = pivot;
        }

        return res;
    }
}
