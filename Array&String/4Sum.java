class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right && left > j && right < nums.length){
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        Integer[] temp = new Integer[]{nums[i], nums[j], nums[left], nums[right]};
                        res.add(Arrays.asList(temp));
                        right++;
                        left--;
                        while(left < nums.length && nums[left] == nums[left - 1]) left++;
                        while(right >= 0 && right < nums.length - 1 && nums[right] == nums[right + 1]) right--;
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}
