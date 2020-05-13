class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return null;
        int[][] res = new int[n][n];
        generateMatrix(0, n, res, 1);
        return res;
    }
    private void generateMatrix(int offset, int size, int[][] res, int start){
        if(size <= 0) return;
        if(size == 1) res[offset][offset] = start;
        for(int i = 0; i < size - 1; i++){
            res[offset][offset + i] = start++;
        }
        for(int i = 0; i < size - 1; i++){
            res[offset + i][offset + size - 1] = start++;
        }
        for(int i = 0; i < size - 1; i++){
            res[offset + size - 1][offset + size - 1 - i] = start++;
        }
        for(int i = 0; i < size - 1; i++){
            res[offset + size - 1 - i][offset] = start++;
        }
        generateMatrix(offset + 1, size - 2, res, start);
    }
}
