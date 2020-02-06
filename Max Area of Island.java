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

//using dfs
