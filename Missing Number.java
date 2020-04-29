class Solution {
    public int missingNumber(int[] nums) {
        //HashSet 2 passes
        //time: o(n)
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int i;
        for(i = 0; i <= nums.length; i++){
            if(!set.contains(i))
                break;
        }
        return i;
        //Sort + one pass check index and value 
        //time: O(n + nlogn)
        
        //bit operation
        //time: O(n) space:O(1)
        int miss = nums.length;
        for(int i = 0; i < nums.length; i++){
            miss = miss ^ (i ^ nums[i]);
        }
        return miss;
        //or sort + index consistent
    }
}
