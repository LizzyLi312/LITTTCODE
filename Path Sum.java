class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs(root, sum, 0);
    }
    private boolean dfs(TreeNode root, int sum, int path){
        if(root == null) return false;
        path += root.val;
        if(sum == path && root.left == null && root.right == null) return true;
        return dfs(root.left, sum, path) || dfs(root.right, sum, path);
    }
}

//using dfs
