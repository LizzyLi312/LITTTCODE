class Solution {
    private Integer prev = null;
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null) res = Math.min(res, root.val - prev);
        prev = root.val; //prev node val 
        inorder(root.right);
    }
}
