class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, 0, res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> sol = new ArrayList<>();
            for(int num : nums){
                sol.add(num);
            }
            res.add(sol);
        }
        Set<Integer> used = new HashSet<>();
        for(int i = idx; i < nums.length; i++){
            if(used.add(nums[i])){
                 swap(nums, i, idx);
                dfs(nums, idx + 1, res);
                swap(nums, i, idx);
            }
        }
        return;
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        dfs(candidates, target, 0, res, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] candidates, int target, int idx, List<List<Integer>> res, int sum, List<Integer> sol){
        if(sum == target){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(sum > target || idx >= candidates.length) return;
        for(int i = idx; i < candidates.length; i++){
            sol.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i, res, sum, sol);
            sol.remove(sol.size() - 1);
            sum -= candidates[i];
            
        }
    }
}
