class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) root = root.left;  //use the property of BST! 
        else root = root.right;
        return searchBST(root, val);  //return recursion!
    }
}

//time: O(n)
