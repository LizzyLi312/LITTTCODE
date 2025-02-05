class Solution {
    int[] color;
    List<Integer>[] g;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        g = new List[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                g[i].add(graph[i][j]);
                g[graph[i][j]].add(i);
            }
        }

        int c = 1;

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, c)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int idx, int c) {
        color[idx] = c;
        for (int x : g[idx]) {
            if (color[x] != 0) {
                if (color[x] == c) return false;
            } else {
                if (!dfs(x, 3 - c)) return false;
            }
        }
        return true;
    }
}
