//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            int left = 0;
            int right = col - 1;
            boolean flag = false;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(target == matrix[i][mid]) flag = true;
                if(target > matrix[i][mid]) left = mid + 1;
                else right = mid - 1;
            }
            if(flag == true) return true;
            else continue;
        }
        return false;
    }
}

//binary search for each row
//time: O(mlogn)    space: O(1)
