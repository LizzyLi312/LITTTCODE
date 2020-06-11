//bottom up. return whether the child and root match value 
class Solution {
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        find(root, -1);
        return res;
    }
    private boolean find(TreeNode root, int val){
        if(root == null) return true;
        boolean left = find(root.left, root.val);
        boolean right = find(root.right, root.val);
        if(left && right){
            res++;
            return root.val == val; //compare the root's val and root's root's value 
        }
        else return false;
    }
}
