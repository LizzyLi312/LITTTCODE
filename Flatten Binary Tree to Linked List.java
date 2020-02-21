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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode[] pre = new TreeNode[1];  //cache the prev root position
        convert(root, pre);
    }
    private void convert(TreeNode root, TreeNode[] pre){
        if(root == null) return;  //leaf node 
        convert(root.right, pre);  //find leaf node 
        convert(root.left, pre);
        root.right = pre[0];  //link it with the prev root
        root.left = null;  //cut the link with the prev root
        pre[0] = root;
    }
}

//tree, recursion
//starts from right to left. if the right leaf node is not null then move it under the left leaf node 
//and then move the prev left leaf node to the right side of the root
