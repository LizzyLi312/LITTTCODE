class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(candidates);  //need to sort first, so time complexity goes up 
        dfs(candidates, target, 0, 0, sol, res);
        return res;
    }
    private void dfs(int[] nums, int target, int level, int sum, List<Integer> sol, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(level > nums.length - 1 || target < sum) return;
        for(int i = level; i < nums.length; i++){
            if(i > level && nums[i] == nums[i -1]) continue;  //check if the num appears before 
            sol.add(nums[i]);
            dfs(nums, target, i + 1, sum + nums[i], sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}

//given an unsorted array and can only use the same number for one time
//time: O(nlogn + summation from 2 power of 0 to 2 power of n-1)
