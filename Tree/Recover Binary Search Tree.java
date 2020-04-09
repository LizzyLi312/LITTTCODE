//straight the tree to an array. there would be 2 errors in the array
//use 2 pointers since we need to compare the current value and the previous value
//e.g. 1 (5 3) (4 2) 6 7 
//the first mistake position is 5(prev pointer). the second mistake happens at 2(cur pointer). then swap
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode[] mistake = new TreeNode[2];
        helper(mistake, root);
        if(mistake[0] != null && mistake[1] != null){
            int temp = mistake[0].val;
            mistake[0].val = mistake[1].val;
            mistake[1].val = temp;
        }
    }
    private TreeNode prev = null;
    private void helper(TreeNode[] mistake, TreeNode cur){
        if(cur == null) return;
        helper(mistake, cur.left);
        if(prev != null && prev.val > cur.val){
            mistake[1] = cur;
            if(mistake[0] == null) mistake[0] = prev;
        }
        prev = cur;
        helper(mistake, cur.right);
    }
}
