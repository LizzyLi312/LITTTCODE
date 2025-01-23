class Solution {
    private enum Status{
        INITIAL, VISITING, VISITED;
    }
    private int curLab = 0;
    private static class V{
        public int label;
        public List<Integer> nexts = new ArrayList<>();
        public Status status;
        public V(int label){
            this.label = label;
            this.nexts = nexts;
            status = Status.INITIAL;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        V[] arr = new V[numCourses];
        for(int i = 0; i < numCourses; i++){
            arr[i] = new V(i);
        }
        int row = prerequisites.length;
        for(int i = 0; i < row; i++){
            int prev = prerequisites[i][1], next = prerequisites[i][0];
            arr[prev].nexts.add(next);
        }
        curLab = numCourses - 1;
        for(int i = 0; i < numCourses; i++){
            if(isCycled(arr, arr[i], res)) return new int[0];
        }
        return res;
    }
    private boolean isCycled(V[] arr, V source, int[] res){
        if(source.status == Status.VISITED) return false;
        if(source.status == Status.VISITING) return true;
        source.status = Status.VISITING;
        for(int next : source.nexts){
            if(isCycled(arr, arr[next],res)) return true;
        }
        res[curLab--] = source.label; //since it is dfs and we touch the bottom and then return value
        source.status = Status.VISITED;
        return false;
    }
}


//time: O(V + E)
//USING HASHSET
class Solution {
    private int curLab = 0;
    private static class V{
        public int label;
        public List<Integer> nexts = new ArrayList<>();
        public int val;
        public boolean visited = false;
        public V(int val){
            this.val = val;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        V[] arr = new V[numCourses];
        for(int i = 0; i < numCourses; i++){
            arr[i] = new V(i);
        }
        int row = prerequisites.length;
        for(int i = 0; i < row; i++){
            int prev = prerequisites[i][1], next = prerequisites[i][0];
            arr[prev].nexts.add(next);
        }
        curLab = numCourses - 1;
        for(int i = 0; i < numCourses; i++){
            if(!topo(arr, arr[i], res, new HashSet<Integer>())) return new int[0];
        }
        return res;
    }
    private boolean topo(V[] arr, V source, int[] res, HashSet<Integer> set){
        if(set.contains(source.val)) return false; //means it on a cycle
        if(source.visited) return true; //pruning
        source.visited = true;
        set.add(source.val);
        for(int next : source.nexts){
            if(!topo(arr, arr[next],res, set)) return false;
        }
        set.remove(source.val); //remove it when we finish a branch
        res[curLab--] = source.val;
        return true;
    }
}

// topo + bfs
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] g = new List[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            int in = p[0], out = p[1];
            g[out].add(in);
            d[in]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) que.offer(i);
        }

        List<Integer> res = new LinkedList<>();

        while (!que.isEmpty()) {
            int t = que.poll();
            res.add(t);
            for (int child : g[t]) {
                if (--d[child] == 0) que.offer();
            }
        }
        if (res.size() != n) return new int[0];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = res.get(i);
        return ans;
    }
}
