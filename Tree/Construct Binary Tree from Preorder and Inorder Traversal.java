// find the root using preorder and then locate the root in post order to find the left and right 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] pre, int p_begin, int p_end, int[] in, int i_begin, int i_end){
        if(i_begin > i_end) return null; // exit condition 
        int val = pre[p_begin]; // the root is the 1st element in the preorder arr
        int i = 0;
        for(i = 0; i < in.length; i++){ // locate the root and the left side should be left tree right should be right tree
            if(in[i] == val) break;
        }
        TreeNode root = new TreeNode(val);
        // i - i_begin is the count of left nodes
        root.left = build(pre, p_begin + 1, p_begin + i - i_begin, in, i_begin, i - 1); //p_begin + 1 since we have used the root; 
        
        root.right = build(pre, p_begin + 1 + i - i_begin, p_end, in, i + 1, i_end);
        return root;
    }
}
