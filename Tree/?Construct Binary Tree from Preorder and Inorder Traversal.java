class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] pre, int p_begin, int p_end, int[] in, int i_begin, int i_end){
        if(i_begin > i_end) return null; //
        int val = pre[p_begin];
        int i = 0;
        for(i = 0; i < in.length; i++){
            if(in[i] == val) break;
        }
        TreeNode root = new TreeNode(val);
        root.left = build(pre, p_begin + 1, p_begin + i - i_begin, in, i_begin, i - 1);
        root.right = build(pre, p_begin + i + 1 - i_begin, p_end, in, i + 1, i_end);
        return root;
    }
}
