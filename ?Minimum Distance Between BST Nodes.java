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
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        Integer[] res = new Integer[2]; //need to store 2 value: prev diff and min diff res
        res[1] = Integer.MAX_VALUE;  //prev
        findMin(root, res);
        return res[1]; //min diff res
    }
    private void findMin(TreeNode root, Integer[] res){ //in-order traversal
        if(root == null) return;
        findMin(root.left, res);
        if(res[0] != null) res[1] = Math.min(res[1], root.val - res[0]);
        res[0] = root.val;
        findMin(root.right, res);
    }
}

