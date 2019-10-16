class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ress = new ArrayList<>();
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
            ress.add(res);
        }
        return ress;
    }
}