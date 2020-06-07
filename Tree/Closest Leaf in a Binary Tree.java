//bottom up. color all the node above target
class Solution {
    private static class Result{
        public int val; //distance from leaf node
        public boolean containsTarget;
        public TreeNode leaf;
        public Result(int val, boolean containsTarget, TreeNode leaf){
            this.val = val;
            this.containsTarget = containsTarget;
            this.leaf = leaf;
        }
    }
    private int min = Integer.MAX_VALUE;
    private TreeNode res = null;
    public int findClosestLeaf(TreeNode root, int k) {
        if(root == null) return -1;
        dfs(root, k);
        return res.val;
    }
    private Result dfs(TreeNode root, int target){
        if(root == null) return null;
        Result left = dfs(root.left, target);
        Result right = dfs(root.right, target);
        if(left == null && right == null){ //leaf node
            if(root.val == target) tryUpdate(0, root);
            return new Result(1, root.val == target, root); 
        }
        else if(right == null) return handleOnlyOneChild(root, left, target);
        else if(left == null) return handleOnlyOneChild(root, right, target);
        else{
            if(root.val == target){
                tryUpdate(left.val < right.val ? left.val : right.val, left.val < right.val ? left.leaf : right.leaf);
                return new Result(0, true, null);
            }
            else if(left.containsTarget){
                tryUpdate(left.val + 1 + right.val, right.leaf);
                return new Result(left.val + 1, true, null);
            }
            else if(right.containsTarget){
                tryUpdate(left.val + 1 + right.val, left.leaf);
                return new Result(right.val + 1, true, null);
            }
            else{
                return new Result(Math.min(left.val, right.val) + 1, false, left.val < right.val ? left.leaf : right.leaf);
            }
        }
    }
    private Result handleOnlyOneChild(TreeNode root, Result child, int target){
        int d = 0;
        TreeNode node = child.leaf;
        if(root.val == target) tryUpdate(child.val + 1, node);
        else d = child.val + 1;
        return new Result(d, root.val == target || child.containsTarget, node);
    }
    private void tryUpdate(int d, TreeNode node){
        if(d < min){
            min = d;
            res = node;
        }
    }
}
