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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return -1;
        TreeNode res = null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = true;
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode firstNode = null;
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(firstNode == null) firstNode = cur;
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            res = firstNode;
        }
        return res.val;
    }
}

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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return -1;
        TreeNode res = null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(flag == false){
                    res = cur;
                    flag = true;
                }
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            flag = false;
        }
        return res.val;
    }
}

//check whether it is a new layer or not 
