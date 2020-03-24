class Solution {
    private int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(matrix, i, j, 0);
            }
        }
        return res + 1;
    }
    private void dfs(int[][] matrix, int i, int j, int cnt){
        res = Math.max(cnt, res);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 && matrix[row][col] > matrix[i][j]){
                cnt++;
                dfs(matrix, row, col, cnt);
                cnt--;
            }
        }
    }
}
//time: O(m^2n^2) time exceed
//need to use pruning
class Solution {
    private int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int max = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res = Math.max(res, dfs(matrix, Integer.MIN_VALUE, i, j, dp));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int cur, int i, int j, int[][] dp){
        int row = matrix.length, col = matrix[0].length;
        if(i >= row || i < 0 || j < 0 || j >= col || matrix[i][j] <= cur) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int max = 0;
        max = Math.max(max, dfs(matrix, matrix[i][j], i - 1, j, dp)); //from matrix[i][j] the longest length
        max = Math.max(max, dfs(matrix, matrix[i][j], i + 1, j, dp));
        max = Math.max(max, dfs(matrix, matrix[i][j], i, j + 1, dp));
        max = Math.max(max, dfs(matrix, matrix[i][j], i, j - 1, dp)); //check 4 directions
        dp[i][j] = max + 1;  //include itself so +1
        return dp[i][j];
    }
}
