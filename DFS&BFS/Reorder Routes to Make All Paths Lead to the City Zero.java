// dfs + record direction, all should point to 0 if not point to the ones that are pointing to 0
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> conn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            conn.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            conn.get(c[0]).add(c[1]);
            conn.get(c[1]).add(-c[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(conn, 0, visited);
    }

    private int dfs(List<List<Integer>> conn, int from, boolean[] visited) {
        int cnt = 0;
        visited[from] = true;
        for (int to : conn.get(from)) {
            if (visited[Math.abs(to)]) continue;
            cnt += dfs(conn, Math.abs(to), visited) + (to > 0 ? 1 : 0);
        }
        return cnt;
    }
}
