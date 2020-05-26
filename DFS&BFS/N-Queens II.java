class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        if(n < 0) return 0;
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++){ //O(n^2)
            for(int j = 0; j < n; j++){
                matrix[i][j] = '.';
            }
        }
        dfs(n, matrix, 0);
        return res;
    }
    private void dfs(int n, char[][] matrix, int level){
        if(level == n){
            res++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(level, matrix, i)){
                matrix[level][i] = 'Q';
                dfs(n, matrix, level + 1);
                matrix[level][i] = '.';
            }
        }
    }
    private boolean isValid(int level, char[][] matrix, int position){
        if(level == 0) return true;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 'Q' && (j == position || Math.abs(position - j) == Math.abs(level - i))) return false;
            }
        }
        return true;
    }
}
