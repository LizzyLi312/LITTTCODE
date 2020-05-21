//Voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count <= 0) candidate = nums[i];
            if(nums[i] == candidate) count++;
            else count--;
        }
        return candidate;
    }
}
//time: O(n)    space: O(1)

//HashMap works too
//time: 2 pass O(n)   space: O(1)

//Sort the array and return nums[n/2] even it if even length array
//time: O(nlogn)    space: O(1)
