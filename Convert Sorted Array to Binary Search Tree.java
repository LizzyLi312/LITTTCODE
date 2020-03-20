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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return contrust(nums, 0, nums.length - 1);
    }
    private TreeNode contrust(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = contrust(nums, start, mid - 1); //mid - 1, mid + 1 since the mid is already taken
        root.right = contrust(nums, mid + 1, end);
        return root;
    }
}
