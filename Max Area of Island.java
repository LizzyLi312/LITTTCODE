class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != 0){
                    max = Math.max(dfs(i, j, grid, 1), max);
                }
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] grid, int count){
        int row = grid.length, col = grid[0].length;
        if(i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        count = 1 + dfs(i + 1, j, grid, count) + dfs(i - 1, j, grid, count) + dfs(i, j + 1, grid, count) + dfs(i, j - 1, grid, count);  //cannot sperate these 4 statement
        return count;
    }
}

class Solution {
    private int res = 0, max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        //cc
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = 0;
                    dfs(grid, i, j);
                    
                } 
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        max++;
        res = Math.max(max, res);
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            int row = i + dir[0], col = j + dir[1];
            dfs(grid, row, col);
        }
    }
}
