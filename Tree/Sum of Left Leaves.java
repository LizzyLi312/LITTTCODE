class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    private int helper(TreeNode root, boolean isLeft){ //keep a flag to record the position
        if(root == null) return 0;
        if(root.left == null && root.right == null && isLeft) return root.val; //make sure it is leaf node and it is the left one 
        return helper(root.left, true) + helper(root.right, false); 
    }
} 
