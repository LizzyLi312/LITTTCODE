//BFS
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
//O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int layer, List<List<Integer>> res){
        //traverse from layer 0 to the bottom layer 
        while(layer >= res.size()) res.add(new ArrayList<>()); //the corresponing relationship between the # of layer and the size of the list
        res.get(layer).add(root.val);
        if(root.left != null) dfs(root.left, layer + 1, res);
        if(root.right != null) dfs(root.right, layer + 1, res);
    }
}
//O(n)
