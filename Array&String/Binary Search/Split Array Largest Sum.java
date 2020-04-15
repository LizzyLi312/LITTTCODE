class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int max = 0;
        long sum = 0;
        for(int i : nums){
            max = Math.max(i, max);
            sum += i;
        }
        long left = max, right = sum;
        while(left <= right){
            long mid = left +(right - left) / 2;
            if(isPossible(nums, mid, m)) right = mid - 1;
            else left = mid + 1;
        }
        return (int) left;
    }
    private boolean isPossible(int[] nums, long target, int m){
        int count = 1;
        int curSum = 0;
        for(int n : nums){
            curSum += n;
            if(curSum > target){
                curSum = n;
                count++;
                if(count > m) return false;
            }
        }
        return true;
    }
}
