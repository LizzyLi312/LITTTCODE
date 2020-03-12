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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            int max = Integer.MIN_VALUE;
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.val > max) max = cur.val;
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
