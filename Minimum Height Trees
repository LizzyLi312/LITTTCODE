class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){ //corner case
            res.add(0);
            return res;
        }
        int nodePool = n;  //works like the que.isEmpty(), to record the # of node has been visited
        TreeNode vs[] = new TreeNode[n];  
        for(int i = 0; i < n; i++){  //build nodes
            vs[i] = new TreeNode(i);
        }
        for(int[] nei : edges){  //build the connections between each nodes
            vs[nei[0]].addNei(nei[1]);
            vs[nei[1]].addNei(nei[0]);
        }
        Queue<Integer> que = new LinkedList<>();  //BFS
        for(int i = 0; i < n; i++){
            if(vs[i].isLeaves()){
                que.add(i);
                nodePool--;
            }
        }
        while(nodePool > 0){  //this while loop will end when there are only the root result left 
            int size = que.size();
            while(size-- > 0){  //on to the next layer 
                int cur = que.poll();
                for(int i : vs[cur].nei){
                    vs[i].removeNei(cur);
                    if(vs[i].isLeaves()){  //check its neis have neis or not 
                        que.add(i); //if it has neis add it in the que
                        nodePool--; 
                    }
                }
            }  
        }
        for(int i : que) res.add(i);  //add result 
        return res;
        
    }
    private class TreeNode{
        public HashSet<Integer> nei;
        public int label;
        public TreeNode(int l){
            label = l;
            nei = new HashSet<Integer>();
        }
        public void addNei(Integer label){
            nei.add(label);
        }
        public void removeNei(Integer label){
            nei.remove(label);
        }
        public boolean isLeaves(){
            return nei.size() == 1;
        }
           
    }
}
