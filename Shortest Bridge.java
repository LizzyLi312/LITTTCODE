// dfs + bfs
class Solution {
    final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean foundFirst = false;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (foundFirst) break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, que, visited);
                    foundFirst = true;
                    break;
                } 
            }
        }

        int step = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] t = que.poll();
                int x = t[0], y = t[1];
                for (int[] dir : dirs) {
                    int a = x + dir[0], b = y + dir[1];
                    if (a < 0 || a >= n || b < 0 || b >= m || visited[a][b]) continue;
                    if (!visited[a][b] && grid[a][b] == 1) return step;
                    que.offer(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int x, int y, Queue<int[]> que, boolean[][] visited) {
        if (visited[x][y] || grid[x][y] == 0) return;

        visited[x][y] = true;
        que.offer(new int[]{x, y});
        for (int[] dir : dirs) {
            int a = dir[0] + x, b = dir[1] + y;
            if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length) continue;
            dfs(grid, a, b, que, visited);
        }
    }
}
