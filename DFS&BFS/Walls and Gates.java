class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0) que.offer(new int[] {i, j});
            }
        }
        int dis = 1;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] temp = que.poll();
                for(int[] dir : DIRECTIONS){
                    int i = temp[0] + dir[0], j = temp[1] + dir[1];
                    if(i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length && rooms[i][j] == Integer.MAX_VALUE){
                        que.offer(new int[]{i, j});
                        rooms[i][j] = dis;
                    }
                }
                // List<int[]> list = convert(temp, rooms);
                // for(int[] cur : list){
                //     if(rooms[cur[0]][cur[1]] == Integer.MAX_VALUE){
                //         rooms[cur[0]][cur[1]] = dis;
                //         que.offer(new int[] {cur[0], cur[1]});
                //     }
                // }
            }
            dis++;
        }
    }
    private int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    // private List<int[]> convert(int[] cur, int[][] rooms){
    //     List<int[]> list = new ArrayList<>();
    //     int row = rooms.length, col = rooms[0].length;
    //     int i = cur[0], j = cur[1];
    //     if(i + 1 < row && rooms[i][j] != -1) list.add(new int[] {i+1, j});
    //     if(i - 1 >= 0 && rooms[i - 1][j] != -1) list.add(new int[] {i - 1, j});
    //     if(j - 1 >= 0 && rooms[i][j - 1] != -1) list.add(new int[]{i, j - 1});
    //     if(j + 1 < col && rooms[i][j + 1] != -1) list.add(new int[]{i, j + 1});
    //     return list;
    // }
}
