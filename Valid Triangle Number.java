// similar to 3 sum 
class Solution {
    public int triangleNumber(int[] nums) {
        // triangle rule: a < b + c, b < a + c, c < a + b
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int l = 0, r = l + 1, res = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) { // i is the biggest num in j,k,i so we only need to make sure this condition is satisfied 
                    res += k - j;
                    k--;
                } else {
                    j++; // move slow pointer if the num[i] is too big 
                }
            } 
        }
        return res;
    }
}
