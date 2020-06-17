class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        Queue<int[]> que = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) que.offer(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][] {{0,1}, {1, 0}, {-1, 0}, {0,-1}};
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                for(int[] dir : dirs){
                    int row = cur[0] + dir[0], col = cur[1] + dir[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
                        que.offer(new int[]{row, col});
                        grid[row][col] = 2;
                    }
                }
            }
            res++;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return res == 0 ? 0 : res - 1;
    }
}
