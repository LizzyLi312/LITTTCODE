//DFS 
class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return getHeight(root);
    }
    private int getHeight(Node root){
        if(root == null) return 0;
        int max = 0;
        for(Node kid : root.children){
            max = Math.max(max, getHeight(kid)); //compare the height of each kid: getHeight(kid)
        }
        return max + 1;
    }
}

//BFS O(n)
class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                Node cur = que.poll();
                int child = cur.children.size();
                for(int i = 0; i < child; i++){
                    que.offer(cur.children.get(i));
                }
            }
            depth++;
        }
        return depth;
    }
}
