import java.util.LinkedList;
import java.util.Queue;

//You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
// You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//        Each 0 marks an empty land which you can pass by freely.
//        Each 1 marks a building which you cannot pass through.
//        Each 2 marks an obstacle which you cannot pass through.
//        For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//        1 - 0 - 2 - 0 - 1
//        |   |   |   |   |
//        0 - 0 - 0 - 0 - 0
//        |   |   |   |   |
//        0 - 0 - 1 - 0 - 0
//        The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
ppublic class Distinct {
    public static int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j, cost);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(cost[i][j] != 0 && grid[i][j] == 0) min = Math.min(min, cost[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private static void bfs(int[][] grid, int i, int j, int[][] cost){
        int row = grid.length, col = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {i, j});
        visited[i][j] = true;
        int dis = 0; //dis = 1, add the dis when add them in the que works too
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                cost[cur[0]][cur[1]] += dis;
                for(int[] dirs : dir) {
                    int newRow = cur[0] + dirs[0], newCol = cur[1] + dirs[1];
                    if (newRow < row && newRow >= 0 && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        que.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            } //finish one layer 
            dis++;
        }
        for(int a = 0; a < row; a++){ //need to check for every building. since only if there was just one building cant reach then its invalid position
            for(int b = 0; b < col; b++){
                if(!visited[a][b] && grid[a][b] == 0) grid[a][b] = 2;  //mark 
            }
        }
    }

    public static void main(String[] args) {
        int[][] ip = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(shortestDistance(ip));
    }
}

//using bfs
//O(m*n)
