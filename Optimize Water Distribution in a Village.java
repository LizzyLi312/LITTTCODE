// graph using Kruksal and virtual root node 

// step: sort possible solution for each village based on cost -> union nodes 

class Solution {
    int[] p;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }

        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) { // build well in village 
            q.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] pipe : pipes) { // get water from the connected village
            q.add(pipe);
        }

        Collections.sort(q, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int[] a : q) {
            int src = a[0], node = a[1], cost = a[2];

            if (find(src) != find(node)) {
                p[find(src)] = find(node);
                res += cost;
            }
        }
        return res;
    }

    private int find(int i) {
        if (i != p[i]) p[i] = find(p[i]);
        return p[i];
    }
}
