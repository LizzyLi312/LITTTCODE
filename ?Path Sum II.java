class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, sum, res, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> sol, int sum){
        if(root == null) return;
        int val = root.val + sum; //
        if(root.left == null && root.right == null && val == target){
            List<Integer> l = new ArrayList<>(sol);
            l.add(root.val);
            res.add(l);
            // sol.add(root.val);
            // res.add(new ArrayList<>(sol));
            return;
        }
        if(root.left == null && root.right == null) return;
        sol.add(root.val);
        dfs(root.left, target, res, sol, val);
        dfs(root.right, target, res, sol, val);
        sol.remove(sol.size() - 1);
    }
}
