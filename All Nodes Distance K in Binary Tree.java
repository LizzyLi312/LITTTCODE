//Graph + bfs
class Solution {
    private Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        buildMap(root, null);
        if(!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        visited.add(target);
        while(!que.isEmpty()){
            int size = que.size();
            if(K == 0){
                for(int i = 0; i < size; i++){
                    res.add(que.poll().val);
                }
                return res;
            }
            while(size-- > 0){
                TreeNode node = que.poll();
                for(TreeNode next : map.get(node)){
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    que.add(next);
                }
            }
            K--;
        }
        return res;
    }
    private void buildMap(TreeNode node, TreeNode parent){
        if(node == null) return;
        if(!map.containsKey(node)){
            map.put(node, new ArrayList<>());
            if(parent != null){
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }
}

//time: O(n)
