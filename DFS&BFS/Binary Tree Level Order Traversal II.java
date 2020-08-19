//bfs
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ress = new LinkedList<>();
        if(root == null) return ress;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = que.poll();
                res.add(temp.val);
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
            }
            ress.add(0, res);
        }
        return ress;
    }
}

//dfs
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    private void dfs(TreeNode root, int layer, List<List<Integer>> res){
        if(layer >= res.size()) res.add(new ArrayList<>());
        res.get(layer).add(root.val);
        if(root.left != null) dfs(root.left, layer + 1, res);
        if(root.right != null) dfs(root.right, layer + 1, res);
        
    }
}
