// math issue:
// 3 steps: find break point from the right -> find the first element that is bigger than the break point -> reverse it from the next element of the break points to the end 
// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
class Solution {
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                idx1 = i;
                break;
            }
        }
        if (idx1 == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int idx2 = nums.length - 1;
        for (int i = nums.length - 1; i >= idx1; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }
        swap(nums, idx1, idx2);
        reverse(nums, idx1 + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
