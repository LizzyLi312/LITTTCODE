class Solution {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max(root);
        return res;
    }
    private int max(TreeNode root){
        if(root == null) return 0;
        int leftSum = max(root.left);
        int rightSum = max(root.right);
        int curMax = Math.max(root.val + leftSum + rightSum, Math.max(Math.max(leftSum + root.val, rightSum + root.val), root.val)); //
        res = Math.max(res, Math.max(curMax, root.val + leftSum + rightSum)); //root.val + leftSum + rightSum can not be returned as a curMax. since it will be a closed route
        return curMax;
    }
}
