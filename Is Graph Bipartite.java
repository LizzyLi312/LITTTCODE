class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < color.length; i++){
            color[i] = -1;  //initialize the node with no color
        }
        for(int i = 0;  i < graph.length; i++){
            if(color[i] == -1 && !bfs(i, graph, color)) return false;  //check your nodes one by one 
            //i for the node number, graph for the neighbors, color for the coloring
        }
        return true;
    }
    private boolean bfs(int node, int[][] graph, int[] color){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        color[node] = 0;  //2 groups of color: 0 and 1
        while(!que.isEmpty()){
            int curr = que.poll();
            for(int nei : graph[curr]){
                if(color[nei] == color[curr]) return false;
                if(color[nei] == -1){ //if the neibor is not colored, put it into queue
                    color[nei] = 1 - color[curr];
                    que.offer(nei);
                }
            }
        }
        return true;
    }
}

//BFS 
//coloring the nodes with 2 colors so you can divide them into 2 groups
//if the neighbor has the same color with the node return false
