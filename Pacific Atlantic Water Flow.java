class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];  
        boolean[][] atlantic = new boolean[row][col];  //use 2 boolean board to record whether this point can flow to Atlantic or Pacific
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < row; i++){ //left side
            que.add(new int[] {i, 0});
            pacific[i][0] = true;
        }
        for(int j = 1; j < col; j++){ //4 loops time: m + n
            que.add(new int[] {0, j});
            pacific[0][j] = true;  //top 
        }
        bfs(res, que, pacific, atlantic, matrix);  //bfs atlantic
        for(int i = 0; i < row; i++){
            que.add(new int[]{i, col - 1});  //right side
            atlantic[i][col - 1] = true;
        }
        for(int j = 0; j < col - 1; j++){  //bottom side, remeber to subtract the last column
            que.add(new int[]{row - 1, j});
            atlantic[row - 1][j] = true;
        }
        bfs(res, que, atlantic, pacific, matrix);  //bfs pacific
        return res;
    }
    private void bfs(List<List<Integer>> res, Queue<int[]>que, boolean[][] selfSet, boolean[][] otherSet, int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(otherSet[cur[0]][cur[1]]) res.add(Arrays.asList(cur[0], cur[1])); //only work at the 2nd bfs
            //do not need to cache the size, cause we do not need the layer searching
            for(int[] dir : directions){
                int rowIdx = cur[0] + dir[0], colIdx = cur[1] + dir[1];
                //if(x >= 0 && x < self.length && y >= 0 && y < self[0].length && matrix[cur[0]][cur[1]] <= matrix[x][y] && !self[x][y]){
                //    que.offer(new int[]{x, y});
                //    self[x][y] = true;
                //}
                
                if(rowIdx < 0 || rowIdx >= row || colIdx < 0 || colIdx >= col || matrix[cur[0]][cur[1]] > matrix[rowIdx][colIdx]) continue;
                if(!selfSet[rowIdx][colIdx]){
                    que.offer(new int[]{rowIdx, colIdx});
                    selfSet[rowIdx][colIdx] = true;
                }
            }
        }
    }
}

//use BFS. Time: O(n*m + m + n) -> O(m*n) space:O(m*n) 

// solution2 dfs
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) return new ArrayList<>();

        int n = heights.length, m = heights[0].length;
        
        boolean[][] pacVisited = new boolean[n][m];
        boolean[][] atlVisited = new boolean[n][m];

        for (int i = 0; i < m; i++) dfs(pacVisited, 0, i, heights); // top row
        for (int i = 0; i < n; i++) dfs(pacVisited, i, 0, heights); // left column
        for (int i = 0; i < m; i++) dfs(atlVisited, n - 1, i, heights); // right column
        for (int i = 0; i < n; i++) dfs(atlVisited, i, m - 1, heights); // bottom row 

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacVisited[i][j] && atlVisited[i][j]) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    res.add(t);
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] visited, int x, int y, int[][] h) {
        int[][] dirs = new int[][]{{0, -1}, {1, 0}, {-1, 0}, {0, 1}};

        visited[x][y] = true;
        for (int[] dir : dirs) {
            int a = dir[0] + x, b = dir[1] + y;
            if (a < 0 || b < 0 || a >= visited.length || b >= visited[0].length || h[x][y] > h[a][b] || visited[a][b]) continue;
            dfs(visited, a, b, h);
        }
    }
}
