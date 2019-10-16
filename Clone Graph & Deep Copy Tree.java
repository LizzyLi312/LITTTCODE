//deep copy tree using recursion
public static TreeNode deepcopy(TreeNode root){
    if(root == null) return root;
    TreeNode newRoot = new TreeNode(root.val);
    newRoot.left = deepcopy(root.left);
    newRoot.right = deepcopy(root.right);
    return newRoot;
}
//clone graph
