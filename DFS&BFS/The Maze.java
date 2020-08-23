class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dirs = {{0,1}, {1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> que = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        que.offer(new int[]{start[0], start[1]});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int[] dir : dirs){
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                while(x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0]; //go back to the valid point
                y -= dir[1];
                if(visited[x][y]) continue;
                visited[x][y] = true;
                if(x == destination[0] && y == destination[1]) return true;
                que.offer(new int[]{x, y});
            }
        }
        return false;
    }
}
