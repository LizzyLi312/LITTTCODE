//bfs
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
//time: O(n)    space:O(n)

//dfs
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>  res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null) return;
        if(d == res.size()) res.add(root.val);
        else res.set(d, Math.max(res.get(d), root.val));
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}
//time: O(n)    space:O(logn)
