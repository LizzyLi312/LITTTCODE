class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];  
        boolean[][] atlantic = new boolean[row][col];  //use 2 boolean board to record whether this point can flow to Atlantic or Pacific
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < row; i++){ //left side
            que.add(new int[] {i, 0});
            pacific[i][0] = true;
        }
        for(int j = 1; j < col; j++){ //4 loops time: m + n
            que.add(new int[] {0, j});
            pacific[0][j] = true;  //top 
        }
        bfs(res, que, pacific, atlantic, matrix);  //bfs atlantic
        for(int i = 0; i < row; i++){
            que.add(new int[]{i, col - 1});  //right side
            atlantic[i][col - 1] = true;
        }
        for(int j = 0; j < col - 1; j++){  //bottom side
            que.add(new int[]{row - 1, j});
            atlantic[row - 1][j] = true;
        }
        bfs(res, que, atlantic, pacific, matrix);  //bfs pacific
        return res;
    }
    private void bfs(List<List<Integer>> res, Queue<int[]>que, boolean[][] selfSet, boolean[][] otherSet, int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(otherSet[cur[0]][cur[1]]) res.add(Arrays.asList(cur[0], cur[1])); //only work at the 2nd bfs
            //do not need to cache the size, cause we do not need the layer searching
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

//use BFS. Time: O(n*m + m + n) -> O(m*n) space:O(m*n)
