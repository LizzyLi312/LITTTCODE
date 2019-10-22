class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;  //corner case 
        int i = 0;
        while(i < nums.length){  //swap 
            if(nums[i] <= 0 || nums[i] == i + 1 || nums[i] > nums.length) i++;  //when it satisfy one of these 3 cases, it stays in the original position
            else if(nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);  //watch out the condition here 
            else i++;
        }  //after this loop the value i should be at the position where is nums[i - 1]
        i = 0;
        while(i < nums.length && nums[i] == i + 1) i++;  //check the consistency between the index and the value 
        return i + 1;
    }
    private void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
