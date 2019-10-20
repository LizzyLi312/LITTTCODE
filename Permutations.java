class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, 0, res);
        return res;
    }
    private void dfs(int[] nums, int level, List<List<Integer>> res){      
        if(level == nums.length - 1){
        List<Integer> sol = new ArrayList<>();
        for(int num: nums){
            sol.add(num);
        }
            res.add(sol);
            return;
        }
        for(int i = level; i < nums.length; i++){
            swap(nums, i, level);
            dfs(nums, level + 1, res);
            swap(nums, i, level);
        }
    }
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
