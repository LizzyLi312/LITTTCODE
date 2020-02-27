class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode node1, TreeNode node2){ //recursion goal: compare the value of these 2 nodes
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;  //can not be node1.val == node2.val return true, cause their subtree could not be symmetric tree as well
        return (isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left));
    }
}

//3 cases: if both nodes are null / if one of them is null / none of them is none 
