class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left); //the return value will always be the left most node
        root.left.left = root.right;
        root.left.right = root;
        root.left = null; //remember to cut the connection 
        root.right = null;
        return newRoot;
    }
}
