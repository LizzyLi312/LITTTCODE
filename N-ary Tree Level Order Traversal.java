class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> sol = new ArrayList<>();
            int size = que.size();
            while(size-- > 0){
                Node cur = que.poll();
                sol.add(cur.val);
                int child = cur.children.size();
                for(int i = 0; i < child; i++){
                    que.offer(cur.children.get(i));
                }
            }
            res.add(sol);
        }
        return res;
    }
}

//bfs O(n^2)
