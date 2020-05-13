class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        spiralOrder(0, 0, matrix.length, matrix[0].length, res, matrix);
        return res;
    }
    private void spiralOrder(int offset_row, int offset_col, int row_size, int col_size, List<Integer> res, int[][] matrix){
        if(row_size <= 0 || col_size <= 0) return;
        if(row_size == 1){
            for(int i = 0; i < col_size; i++)
                res.add(matrix[offset_row][offset_col + i]);
        }
        else if(col_size == 1){
            for(int i = 0; i < row_size; i++){
                res.add(matrix[offset_row + i][offset_col]);
            }
        }
        else{
            for(int i = 0; i < col_size - 1; i++){ //every time only add size - 1, since the last element belongs to tge next loop
                res.add(matrix[offset_row][offset_col + i]);
            }
            for(int i = 0; i < row_size - 1; i++){
                res.add(matrix[offset_row + i][offset_col + col_size - 1]);
            }
            for(int i = 0; i < col_size - 1; i++){
                res.add(matrix[offset_row + row_size - 1][offset_col + col_size - 1 - i]);
            }
            for(int i = 0; i < row_size - 1; i++){
                res.add(matrix[offset_row + row_size - 1 - i][offset_col]);
            }
        }
        spiralOrder(offset_row + 1, offset_col + 1, row_size - 2, col_size - 2, res, matrix);
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        spiralOrder(0, 0, matrix.length - 1, matrix[0].length - 1, res, matrix);
        return res;
    }
    private void spiralOrder(int left, int top, int bottom, int right, List<Integer> res, int[][] matrix){
        if(right < left || bottom < top) return;
        if(bottom == top && left <= right){ //corner case 
            for(int i = left; i <= right; i++)
                res.add(matrix[bottom][i]);
        }
        else if(left == right && top <= bottom){
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][left]);
            }
        }
        else{
            for(int i = left; i < right; i++){
              res.add(matrix[top][i]);
            }
            for(int i = top; i < bottom; i++){
                res.add(matrix[i][right]);
            }
            for(int i = right; i > left; i--){
                res.add(matrix[bottom][i]);
            }
            for(int i = bottom; i > top; i--){
                res.add(matrix[i][left]);
            }
        } 
        
        spiralOrder(left + 1, top + 1, bottom - 1, right - 1, res, matrix);
    }
}
