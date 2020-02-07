class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  //time: O(nlogn)
        if(nums == null || nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        dfs(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums, int idx, List<List<Integer>> res, List<Integer> ress){
        if(idx == nums.length) return;
        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i - 1]) continue;  //only when idx == i, the duplicate can make it to the result 
            ress.add(nums[i]);
            res.add(new ArrayList<Integer>(ress));
            dfs(nums, i + 1, res, ress);
            ress.remove(ress.size() - 1);
        }
        return;
    }
}

//dfs. time: O(nlogn + n)
