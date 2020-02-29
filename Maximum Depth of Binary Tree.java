class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;  //add depth here or add 1 on left or right. the value is returned to the parents node 
    }
}

//time: O(2^logn) = O(n)
//Or BFS 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
