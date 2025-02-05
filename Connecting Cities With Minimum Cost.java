class Solution {
    int[] p;
    public int minimumCost(int n, int[][] connections) {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        List<int[]> q = new ArrayList<>();
        for (int[] conn : connections) {
            q.add(conn);
        }
        Collections.sort(q, (a, b) -> (a[2] - b[2]));
        
        int res = 0, cnt = 0;
        for (int[] x : q) {
            int a = x[0], b = x[1], cost = x[2];
            if (find(a) != find(b)) {
                p[find(a)] = find(b); //need to assign b's ancestor(find(b)) to a's ancestor
                res += cost;
                cnt++;
            }
            
        }

        return cnt < n - 1 ? -1 : res;
    }

    private int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
}
