class Solution {
    private int res = 0;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root)
    {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int val = Math.max(left + root.val, Math.max(right + root.val, root.val));  //each node has three route: root itself, root + right, root + left. find the max one
        res = Math.max(res, Math.max(val, left + right + root.val));
        return val;  //return the max route to the prev node
    }
}
