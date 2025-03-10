// dfs
class Solution {
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length == 0 || postorder.length == 0) return new TreeNode();

        TreeNode root = cons(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode cons(int[] preorder, int preSt, int preEd, int[] postorder, int posSt, int posEd) {
        if (preSt > preEd || posSt > posEd) return null;

        int val = preorder[preSt]; // find the root always the 1st element in the preorder arr
        TreeNode t = new TreeNode(val);
        if (preSt == preEd) return t; // means there is only 1 node so return itself

        int left = preorder[preSt + 1]; // the next element next to root is the left child 
        int leftP = -1;
        for (int i = posSt; i <= posEd; i++) { // look for thr left child in postOrder arr
            if (postorder[i] == left) {
                leftP = i;
                break;
            }
        }
        
        int cnt = leftP - posSt + 1; //post order visit left first so from the beginning to leftP should be the left nodes
        t.left = cons(preorder, preSt + 1, preSt + cnt, postorder, posSt, leftP);
        t.right = cons(preorder, preSt + cnt + 1, preEd, postorder, leftP + 1, posEd - 1);
        return t;
    }
}
