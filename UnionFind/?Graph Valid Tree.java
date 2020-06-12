//tree is a sprcial graph. # of edge = # of node + 1. but this can not be the standard to tell it is a tree or not
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] e : edges){
            int p = e[0], q = e[1];
            if(uf.find(p, q)) return false; //means there is loop in the graph, so it is not a tree
            else uf.union(p,q);
        }
        return uf.size == 1;
    }
    class UnionFind{
        private int[] sz;
        private int[] parent;
        public int size; //# of the clustered node 
        public UnionFind(int n){
            size = n;
            parent = new int[n];
            sz = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                sz[i] = 1;
            }
        }
        public boolean find(int p, int q){
            return root(p) == root(q); 
        }
        private int root(int i){
            int temp = i;
            while(i != parent[i]){
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            parent[temp] = i;
            return i;
        }
        public void union(int p, int q){
            int rootP = root(p), rootQ = root(q);
            if(sz[rootP] < sz[rootQ]){
                int temp = rootP;
                rootP = rootQ;
                rootQ = temp;
            }
            parent[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
            this.size--;
        }
    }
}
