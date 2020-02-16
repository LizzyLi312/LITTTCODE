class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return matrix;
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> que = new LinkedList<>();
        int dis = 1;
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    que.offer(new int[] {i, j});
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- >0){
                int[] cur = que.poll();
                for(int[] dir : directions){
                    int newRow = dir[0] + cur[0], newCol = dir[1] + cur[1];
                    if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && matrix[newRow][newCol] == 1 && res[newRow][newCol] == 0) {
                        res[newRow][newCol] = dis;
                        que.offer(new int[] {newRow, newCol});
                    }
                }
            }
            dis++;
        }
        return res;
    }
}
