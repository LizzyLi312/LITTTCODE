class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] < target){
                    res += end - start; //all elements between start and end will satisfy the condition since they are smaller than end element
                    start++;
                }
                else end--;
            }
        }
        return res;
    }
}
