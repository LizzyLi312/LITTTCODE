/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(p == root || q == root) return root;  
        if(p == q) return p;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}

//2 cases: p or q is the LCA, if p is q's ancestor. then p is q and p's LCA. we cant visit q if p is LCA
//if not. If left side has p then return p. coloring. if left side has q then coloring with q i.e. return q. 
//if p & q are on both side then return root. if not then return the side which has color
