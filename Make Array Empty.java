// solution1 math
class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        long res = n; // the min step will be n since if all the nums are in increasing order, then it will take n operations to remove them

        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (map.get(nums[i]) < map.get(nums[i - 1])) res += n - i;
          /*On i-th step we've already removed i-1 smallest elements and can ignore them. If an eleent A[i] has smaller i
          ndex in origin array than previous element A[i-1] -> we should rotate whole left left array n-i times to set A[i] element on the 1st position. T
          */
        }
        return res;
    }
}
