//time: O(n), space: O(1)
//general idea: count how many 1s in each bit
/*
e.g. num: [2,3,2,2]
 2: 0 0 1 0
 3: 0 1 1 0
 2: 0 0 1 0
 2: 0 0 1 0
 so if we only look at the 3 twos. there are 3 ones in the second position from right 
 when we look at 3 at the same time then there is an extra 1 on postion 2 and position 3
 all we need to do is find where there is an extra 3. we can get it there by mod 3 
*/
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int res = 0;
        for(int i = 0; i < 32; i++){ //iterate each position 
            int digitSum = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i)  &  1) == 1){
                    digitSum++; //count 1s
                    digitSum %= 3;
                }
            }
            if(digitSum != 0) res |= (digitSum << i);
        }
        return res;
    }
}

//HashMap could work too. 2 pass.
