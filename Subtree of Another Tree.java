//similar as same tree
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t != null) return false;
        if(isSameTree(s, t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right, t);  //in this way find the node
    }
    private boolean isSameTree(TreeNode left, TreeNode right){  //use the same tree to find the start treenode
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }
}

//m: nodes in tree s; n: nodes in tree t
//time: worst case: O(m*n) general case: O(m) 
