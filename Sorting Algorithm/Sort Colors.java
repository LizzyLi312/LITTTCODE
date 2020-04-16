//1 pass
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for(int i = 0; i <= two; i++){ //if it is 1 then do nothing. eventually we can gather all 1 in the middle 
            if(nums[i] == 0) swap(nums, zero++, i); //after swap with 0. i is a new number and not 2 since we already checked 
            else if(nums[i] == 2) swap(nums, two--, i--); //i-- since we need to chech the new i is 2 or not
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//2 pass. count sort
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int[] count = new int[3];
        for(int color : nums){
            if(color == 0) count[0]++;
            if(color == 1) count[1]++;
            if(color == 2) count[2]++;
        }
        for(int i = 0; i < count[0]; i++){
            nums[i] = 0;
        }
        for(int i = count[0]; i < count[0]+ count[1]; i++){
            nums[i] = 1;
        }
        for(int i = count[0] + count[1]; i < nums.length; i++){
            nums[i] = 2;
        }
    }
}
