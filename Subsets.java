class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null) return res;
        res.add(new ArrayList<>());  //a null set should be in the result too
        dfs(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs(List<List<Integer>> result, int[] nums, int index, List<Integer> list){
        if(index == nums.length) return;
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(result, nums, i + 1, list);
            list.remove(list.size() - 1);  //backtracing
        }
        return;
    }
}

//O(2^n)
