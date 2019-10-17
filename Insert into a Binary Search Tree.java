class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.left == null && root.val > val) root.left = new TreeNode(val);
        if(root.right == null && root.val < val) root.right = new TreeNode(val);  //need to cache since you do not know where the new node should be inserted
        if(root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;
    }
}
