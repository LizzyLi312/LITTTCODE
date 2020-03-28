class Solution {
    public int minPathSum(int[][] grid) {
    //dp1
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        //base caee
        dp[0][0] = grid[0][0];
        for (int j = 1; j < grid.length; j++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0]; 
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        //Transfer equation
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i ][j ];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
    //dp2
//         for(int i = 0; i <= grid.length; i++){
//             dp[i][0] = Integer.MAX_VALUE;
            
//         }for(int j = 0; j <= grid[0].length; j++){
//             dp[0][j] = Integer.MAX_VALUE;
//         }
//         for(int i = 1; i <= grid.length; i++){
//             for (int j = 1; j <= grid[0].length; j++){
//                 if(i == 1 && j == 1) dp[i][j] = grid[i -1][j - 1];
//                 else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + grid[i - 1][j - 1];
//             }
//         }
//         return dp[grid.length][grid[0].length];
//     }

//dfs
    // private void dfs(int[][] grid, int i, int j, int[] res, int sum, int[][] dp){
    //     int row = grid.length, col = grid[0].length;
    //     if(i < 0 || i >= row || j < 0 || j >= col) return;
    //     if(dp[i][j] != 0) return dp[i][j];
    //     if(i == row - 1 && j == col - 1){
    //         sum += grid[i][j];
    //         res[0] = Math.min(sum, res[0]);
    //         return res[0];
    //     }
    //     int[][] directions = new int[][] {{0, 1}, {1, 0}};
    //     for(int[] dir : directions){
    //         int newR = dir[0] + i, newC = dir[1] + j;
    //         res[0] = Math.min(dfs(grid, newR, newC, res, sum + grid[i][j]), res[0]);
    //     }
    // }
}
