//bfs
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
//time: O(n)

//dfs
class Solution {
    private int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return -1;
        res = root.val;
        dfs(root, 1);
        return res;
    }
    private int max = 1;
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(depth > max){
            res = root.val;
            max = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
//time: O(n)
