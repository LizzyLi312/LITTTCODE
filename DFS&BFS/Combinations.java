class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        dfs(k, n, res, 1, new ArrayList<>());
        return res;
    }
    private void dfs(int k, int n, List<List<Integer>> res, int idx, List<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i <= n; i++){
            temp.add(i);
            dfs(k, n, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
