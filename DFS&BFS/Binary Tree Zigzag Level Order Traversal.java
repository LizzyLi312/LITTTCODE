class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ress = new LinkedList<>();
        if(root == null) return ress;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int count = 1;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = que.poll();
                if(count % 2 == 0)  //tell the even and odd here
                    res.add(0, temp.val);  //reverse linkedlist
                else 
                    res.add(temp.val);
                if(temp.left != null) que.offer(temp.left);  //do not tell the even and odd here
                if(temp.right != null) que.offer(temp.right);
            }
            count++;
            ress.add(res);
        }
        return ress;
    }
}


//dfs
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0, res, true);
        return res;
    }
    private void dfs(TreeNode root, int layer, List<List<Integer>> res, boolean isEven){
        if(layer >= res.size()) res.add(new ArrayList<>());
        if(isEven) res.get(layer).add(root.val);
        else res.get(layer).add(0, root.val);
        if(root.left != null) dfs(root.left, layer + 1, res, !isEven);
        if(root.right != null) dfs(root.right, layer + 1, res, !isEven);
    }
}
//time: O(n)
