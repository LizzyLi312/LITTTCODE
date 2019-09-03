class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int start = 0;
        int cols = matrix[0].length;
        int row = matrix.length;
        int end = cols * row - 1;
        int c = 0;
        int r = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            c = mid % cols;
            r = mid / cols;
            if(matrix[r][c] == target) return true;
            if(matrix[r][c] < target) start = mid + 1;
            else end = mid - 1;
        }
        return matrix[r][c] == target ? true : false;
    }
}

//Need to know the structure of matrix. [row_position][col_position]
//                column
//        [0,0], [0,1], [0,2], [0,3],
//        [1,0],
// row    [2,0],
//Transform the matrix into an array. Find the relationship between the index of array and the corresponding position in the 
//matirx. The row = index_of_array / cols; the column = index_of_array % cols. Demo one time and you will figure it out
//the key of solving problems related to Matrix is finding the relation between the index.
//And i used the binary search for this question to reduce the time.
//overall, the time is O(log(m*n)); space: O(1)
