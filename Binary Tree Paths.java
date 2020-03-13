class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, new StringBuilder());
        return res;
    }
    private void dfs(TreeNode root, List<String> res, StringBuilder sol){
        if(root == null)
            return;
        int len = sol.length();  //need to cache the length befroe the new value gets added in. when we process every node, we have a length.
        if(root.left == null && root.right == null){  //avoid an extra "->" in the end
            sol.append(root.val);
            res.add(sol.toString()); //add to the res when it meets the leaf node
        }
        else{
            sol.append(root.val + "->"); 
            dfs(root.left, res, sol);
            dfs(root.right, res, sol);
            
        }
        sol.setLength(len);  //backtracing. can not use len - 1 since the -> counts to length too
    }
}
