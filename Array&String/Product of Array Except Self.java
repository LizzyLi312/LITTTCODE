class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[] {0};
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = findProduct(nums, 0, i - 1) * findProduct(nums, i + 1, nums.length - 1);
        }
        return res;
    }
    private int findProduct(int[] nums, int start, int end){
        if(start > end) return 1;
        int res = 1;
        for(int i = start; i <= end; i++){
            res *= nums[i];
        }
        return res;
    }
}
//time: O(n^2) space: O(n)

/*
Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[] {0};
        int n = nums.length;
        int[] res = new int[n];
        // int left = 1;
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= right; //left * right
            right *= nums[i]; //right: 1 -> 1*5 -> 1*5*4 -> 1*5*4*3 
        }
        return res;
    }
}
//time: O(n)
