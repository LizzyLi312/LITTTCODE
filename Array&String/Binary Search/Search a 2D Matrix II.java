class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int rowIdx = row - 1, colIdx = 0;
        while(rowIdx >= 0 && colIdx < col){
            if(matrix[rowIdx][colIdx] == target) return true;
            else if(matrix[rowIdx][colIdx] < target) colIdx++;
            else rowIdx--;
        }
        return false;
    }
}
