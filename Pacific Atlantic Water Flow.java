class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < row; i++){
            que.add(new int[] {i, 0});
            pacific[i][0] = true;
        }
        for(int j = 1; j < col; j++){
            que.add(new int[] {0, j});
            pacific[0][j] = true;
        }
        bfs(res, que, pacific, atlantic, matrix);
        for(int i = 0; i < row; i++){
            que.add(new int[]{i, col - 1});
            atlantic[i][col - 1] = true;
        }
        for(int j = 0; j < col - 1; j++){
            que.add(new int[]{row - 1, j});
            atlantic[row - 1][j] = true;
        }
        bfs(res, que, atlantic, pacific, matrix);
        return res;
    }
    private void bfs(List<List<Integer>> res, Queue<int[]>que, boolean[][] selfSet, boolean[][] otherSet, int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(otherSet[cur[0]][cur[1]]) res.add(Arrays.asList(cur[0], cur[1]));
            for(int[] dir : directions){
                int rowIdx = cur[0] + dir[0], colIdx = cur[1] + dir[1];
                if(rowIdx < 0 || rowIdx >= row || colIdx < 0 || colIdx >= col || matrix[cur[0]][cur[1]] > matrix[rowIdx][colIdx]) continue;
                if(!selfSet[rowIdx][colIdx]){
                    que.offer(new int[]{rowIdx, colIdx});
                    selfSet[rowIdx][colIdx] = true;
                }
            }
        }
    }
}
