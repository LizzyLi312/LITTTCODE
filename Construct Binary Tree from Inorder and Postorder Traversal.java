class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        
    }
    private TreeNode build(int[] in, int i_begin, int i_end, int[] po, int p_begin, int p_end){
        //preorder to construct tree
        if(i_begin > i_end) return null;
        int val = po[p_end];
        TreeNode root = new TreeNode(val);
        int i = 0;
        //find the root value to define the boundary between left & right subtrees
        for(i = i_begin; i < i_end; i++){
            if(in[i] == val) break;
        }
        //the left subtree, in inorder array, should be in the section[i_begin, i - 1]; in postorder array, [p_begin, p_begin+i-1-i_begin]
        //i - 1 - i_begin is the number of subtree without the root
        root.left = build(in, i_begin, i - 1, po, p_begin, p_begin + i - 1 - i_begin); 
        
        //the right subtree, in the inorder array, in the section[i + 1, i_end]; in postorder array, [p_begin + i - i _begin,p_end-1]
        //left ends in postorder at p_begin + i - 1 - i_begin. so right begin at that + 1; since the root already used so end - 1
        root.right = build(in, i + 1, i_end, po, p_begin + i - i_begin, p_end - 1);
        return root;
    }
}
