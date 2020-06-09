class Solution {
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        find(root);
        return res;
    }
    private int find(TreeNode root){
        if(root == null) return 0;
        int left = find(root.left);
        int right = find(root.right);
        int localLen = 1; //need to keep a global variable 
        if(root.left != null && root.val + 1 == root.left.val) localLen = left + 1;
        if(root.right != null && root.val + 1 == root.right.val) localLen = Math.max(right + 1, localLen);
        res = Math.max(res, localLen);
        return localLen;
    }
}
