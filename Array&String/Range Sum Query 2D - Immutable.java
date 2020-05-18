//2 pass for loop O(n^2)
//pre-compute time: O(m*n), sum Region: O(1)
//dp[i][j] is a area with (0, 0) as the left top corner, (i, j) as the right bottom coner
class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] - dp[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //dp[i][j] -> area(matrix[0][0] to matrix[i][j])
        //do not subtract dp[row1 + 1][col2 + 1] since it includes the sum of row1 which is what we want 
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
