class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return true;
        return validBST(Long.MAX_VALUE, Long.MIN_VALUE, root);
    }
    private boolean validBST(long max, long min, TreeNode root){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return validBST(root.val, min, root.left) && validBST(max, root.val, root.right);
    }
}

//keep a range for each node and check if it is in the range or not
//another solution: traversal
