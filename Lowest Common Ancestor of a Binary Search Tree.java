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
        if(root == q || root == p) return root;
        if(p == q) return p;
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);  //make sure the position of p and q
        
        if(root.val > p.val && root.val < q.val) return root;
        else if(root.val < p.val) return lowestCommonAncestor(root.right, p, q); //since p is smaller than q, so if root is smaller than p. Then need to go bigger 
        else return lowestCommonAncestor(root.left, p, q);
    }
}

//use the property of BST. val of left treenode is smaller than the root, val of right treenode is bigger than the root
