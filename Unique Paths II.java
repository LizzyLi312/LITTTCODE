//dp meaning: how many ways to from[0][0] to [i][j].
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = 0; //if have obstacle then we can not get to the final point so there is 0 way 
                else{
                    if(i == 1 && j == 1) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j] + dp[i][ j-1];
                }
            }
        }
        return dp[row][col];
    }
}
