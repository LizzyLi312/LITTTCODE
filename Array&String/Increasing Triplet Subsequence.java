/.//
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 0) return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){ 
            int third = nums[i];
            if(third > second) return true; //if there is a third element bigger than the other 2 then we found the subsequence 
            else if(third < first) first = third;
            else if(third > first && third < second) second = third;
        }
        return false;
    }
}
//time: O(n)
