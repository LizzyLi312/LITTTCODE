class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return res;
    }
    private int res = 0;
    private void helper(TreeNode root, int sum){
        if(root == null) return; //still can reach the null under the leaf nodes
        if(root.left == null && root.right == null){
            res += sum * 10 + root.val;
            return;
        }
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}
