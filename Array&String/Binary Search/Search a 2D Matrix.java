class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int n = matrix.length, m = matrix[0].length; 

        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int x = mid / m, y = mid % m; // how to get x and y
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) l = mid + 1;
            else r = mid - 1;
        }
        return matrix[l / m][l % m] == target; // check if there is only 1 element 
    }
}
