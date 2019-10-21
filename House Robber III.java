class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;  //base case
        int res = 0;
        if(root.left != null)
            res = res + rob(root.left.left) + rob(root.left.right);   //similar as dp[i-2] + nums[i]
        if(root.right != null)
            res = res + rob(root.right.left) + rob(root.right.right);
        return Math.max(res + root.val, rob(root.left) + rob(root.right));  //similar as dp[i] comparing to dp[i-1]
    }
}
