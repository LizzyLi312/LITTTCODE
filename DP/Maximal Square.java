//main idea: recoding the max side length
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == '1'){ //square property; and be careful about the relationship between the index
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i -1][j], dp[i][j -1])) + 1;
                    max = Math.max(max, dp[i][j]); //max side length
                }
            }
        }
        return max * max;
    }
}
