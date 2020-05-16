class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        rotate(0, matrix.length, matrix);
    }
    private void rotate(int offset, int size, int[][] matrix){
        if(size <= 0) return;
        for(int i = 0; i < size - 1; i++){ //rotate length - 1 elements each time 
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset]; //7 -> 1
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i]; //9 -> 7
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1]; //3 -> 9
            matrix[offset + i][offset + size - 1] = temp;
        }
        rotate(offset + 1, size - 2, matrix);
    }
}
