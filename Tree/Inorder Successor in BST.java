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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        TreeNode prev = null, cur = root;
        while(cur != null){
            if(cur.val <= p.val){
                cur = cur.right;  //since root.val < p so we do not have to update prev 
            }
            else{ //the last update value should be the last one who is larger than p
                prev = cur;
                cur = cur.left;
            }
        }
        return prev;
    }
}
