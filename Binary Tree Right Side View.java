class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode last = null;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
                last = cur;
            }
            res.add(last.val);
        }
        return res;
    }
}

//dfs
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        helper(root, 0);
        return res;
    }
    private void helper(TreeNode root, int level){
        if(level == res.size()) res.add(root.val);
        if(root.right != null) helper(root.right, level + 1);
        if(root.left != null) helper(root.left, level + 1);
    }
}
