class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int group1 = 0, group2 = 0;
        int xor = 0;
        for(int n : nums){
            xor ^= n; //anything xor itself is 0. anything xor 0
            //the result will be the 3 different number xor each other 
        }
        int mask = 1;
        while((xor & mask) == 0){
            mask <<= 1; //find the first different position 
        }
        for(int n : nums){
            if((n & mask) == 0) group1 ^= n; //if n & mask is 0 to make sure this 2 numbers are in different group
            else group2 ^= n;
        }
        return new int[]{group1, group2};
    }
}
