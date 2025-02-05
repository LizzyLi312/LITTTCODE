class Solution {
    int[] color;
    List<Integer>[] g;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new int[n];
        g = new List[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] dislike : dislikes) {
            int a = dislike[0] - 1, b = dislike[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int idx, int c) {
        color[idx] = c;
        for (int j : g[idx]) {
            if (color[j] != 0) {
                if (color[j] == c) return false;
            } else {
                if (!dfs(j, 3 - c)) return false;
            }
        }
        return true;
    }
}
