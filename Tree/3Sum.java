class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, r = len - 1;
            while(l < r){
                if(nums[l] + nums[r] == target){
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[l]);
                    one.add(nums[r]);
                    res.add(one);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) l++; //deduplicate
                    while(l < r && nums[r] == nums[r + 1]) r--; //dedeplicate
                }
                else if(nums[l] + nums[r] < target) l++;
                else r--;
            }
        }
        return res;
    }
}
