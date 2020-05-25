class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length; 
        int n = grid[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    I.add(i);
                    J.add(j);
                }
            }
        }
        return getMin(I) + getMin(J);
    }
    private int getMin(List<Integer> grid){
        int i = 0, j = grid.size() - 1, sum = 0;
        Collections.sort(grid);
        while(i < j){
            sum += grid.get(j--) - grid.get(i++);
        }
        return sum;
    }
}
