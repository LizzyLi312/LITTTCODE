// cannot use dfs since the order would be messed up 
//bfs: using 2 queue to store the index and node consistently. hashmap to store the relationship
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        Queue<Integer> cols = new LinkedList<>();
        cols.offer(0);
        int min = 0, max = 0;
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            int idx = cols.poll();
            if(!map.containsKey(idx)) map.put(idx, new ArrayList<>());
            map.get(idx).add(temp.val);
            if(temp.left != null){
                que.offer(temp.left);
                cols.offer(idx - 1);
                min = Math.min(min, idx - 1); //update the min and the max here 
            }
                if(temp.right != null){
                    que.offer(temp.right);
                    cols.offer(idx + 1);
                    max = Math.max(max, idx + 1);
                }
        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
