class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //using recursion 
        if(root == null) return root;
        if(root.left == null && root.val > val) root.left = new TreeNode(val);
        if(root.right == null && root.val < val) root.right = new TreeNode(val); 
        if(root.val < val) root.right = insertIntoBST(root.right, val); //need to cache since you do not know where the new node should be inserted
        else root.left = insertIntoBST(root.left, val);
        return root;
        //using interation
        if(root == null) return root;
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null){
            prev = cur;
            if(cur.val < val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        if(prev.val > val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return root;
    }
}
