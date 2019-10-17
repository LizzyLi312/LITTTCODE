public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;  //corner case
        if(root.left == null) return root;  //base case
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;  //need to be dis connected
        root.right = null;
        return newRoot;
}

//find the pattern: the left-most node will be the new node. So find it using recursion
//then find the relationship between old root and new root
//using recursion to return the newRoot for each changing 
