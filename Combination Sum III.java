class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i = 1; i < 10; i++){
            nums[i - 1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(nums, k, n, 0, sol, res, 0);
        return res;
    }
    private void dfs(int[] nums, int k, int n, int index, List<Integer> sol, List<List<Integer>> res, int sum){
        if(sol.size() == k && sum == n){
            res.add(new ArrayList<>(sol));
            return;
        }
        if(index > nums.length || sum > n) return;
        for(int i = index; i < nums.length; i++){
            sol.add(nums[i]);
            dfs(nums, k, n, i + 1, sol, res, sum + nums[i]);
            sol.remove(sol.size() - 1);
        }
    }
}
