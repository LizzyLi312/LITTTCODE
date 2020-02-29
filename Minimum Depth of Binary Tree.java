class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left == null) return right + 1; //check corner case
        if(root.right == null) return left + 1;
        return Math.min(left, right) + 1;
    }
}

//if you want to copy the entire code of the max path, it couldn't work. 
//Cause it has a corner case:[1, 2]. only has one child

