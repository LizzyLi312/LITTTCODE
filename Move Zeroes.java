class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 1) return;
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[slow] != 0) slow++;
            else if(nums[fast] != 0) swap(nums, fast, slow++);
        }
        return;
    }
    private void swap(int[] arr, int fast, int slow){
        int temp = arr[fast];
        arr[fast] = arr[slow];
        arr[slow] = temp;
    }
}
//Using 2 pointers 
