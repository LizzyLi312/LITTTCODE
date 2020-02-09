class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> sol = new ArrayList<>();
        dfs(candidates, target, 0, sol, res, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int level, List<Integer> sol, List<List<Integer>> res, int sum){
        if(sum == target){  //the result could be generated on every node
            res.add(new ArrayList<>(sol));
            return;
        }
        if(sum > target || level >= nums.length) return;  //2 base case, need to write seperatly
        for(int i = level; i < nums.length; i++){
            sol.add(nums[i]);
            dfs(nums, target, i, sol, res, sum + nums[i]);  
            sol.remove(sol.size() - 1);
        }
    }
}

//allow the element be used multiple times, so no need to add level number when call the recursion loop

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
            sum -= candidates[i];  //backtracing
            
        }
    }
}
