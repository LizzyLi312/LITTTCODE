// sliding window to keep count of 0 
class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;

        int left = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt++;
            if (cnt > k) {
                while (cnt > k) {
                    if (nums[left] == 0) cnt--;
                    left++;
                }
            }
            res = Math.max(res, i - left + 1);

        }
        return res;
    }
}
