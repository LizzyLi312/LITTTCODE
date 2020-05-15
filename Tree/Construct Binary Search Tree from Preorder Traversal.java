//the property of BST
class Solution {
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    private TreeNode bstFromPreorder(int[] pre, int bound){
        if(i == pre.length || pre[i] > bound) return null;
        TreeNode root = new TreeNode(pre[i++]);
        root.left = bstFromPreorder(pre, root.val); //left subtree is smaller than the root
        root.right = bstFromPreorder(pre, bound); 
        return root;
    }
}
