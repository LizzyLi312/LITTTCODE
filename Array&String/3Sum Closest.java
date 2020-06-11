//find all combination
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int temp = nums[i] + nums[start] + nums[end];
                if(temp == target) return temp;
                if(Math.abs(temp - target) < Math.abs(res - target)) res = temp;
                if(temp < target) start++;
                if(temp > target) end--;
            }
        }
        return res;
    }
}
