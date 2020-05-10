//if a vertex is not on a circle then it is on the critical edge. return a time stamp to check it is on one or not
//if the return_ts = ts then prev vertex it is on the ce.
//else if return_ts > ts then it is on ce 
//else if return_ts < ts then it is not on ce
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 2) return res;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> conn : connections){ //create graph
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        int[] ts = new int[n];
        isCycled(res, 0, -1, graph, ts); //dfs
        return res;
    }
    private int t = 1;
    private int isCycled(List<List<Integer>> res, int cur, int prev, List<List<Integer>> graph, int[] ts){
        if(ts[cur] > 0) return ts[cur]; //pruning
        ts[cur] = t++;
        int mints = Integer.MAX_VALUE; 
        for(int next : graph.get(cur)){
            if(next == prev) continue; //since it is undirected so we it might go back and forth
            int nei_ts = isCycled(res, next, cur, graph, ts); 
            mints = Math.min(mints, nei_ts); 
        }
        if(mints >= ts[cur]){ //check cycled 
            if(prev >= 0) res.add(Arrays.asList(prev, cur));
        }
        return Math.min(ts[cur], mints); 
    }
}
