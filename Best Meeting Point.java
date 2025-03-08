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

// quick select 
class Solution {
    // totalDis = (x - a) + (x - x) + (c - x) = c - a
    public int minTotalDistance(int[][] grid) {
        // keep dis from origin in a list and use quick select to find the median, calculate the dis
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        List<Integer> col = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        int medCol = quickSelect(col, 0, col.size() - 1, 1 + col.size() / 2);
        int medRow = quickSelect(row, 0, row.size() - 1, 1 + row.size() / 2);

        int res = 0;
        for (int r : row) {
            res += Math.abs(medRow - r);
        }
        for (int c : col) {
            res += Math.abs(medCol - c);
        }
        return res;
    }

    private int quickSelect(List<Integer> pos, int left, int right, int k) {
        if (left >= right) return pos.get(right);
        int pivot = pos.get(left + (right - left) / 2), l = left - 1, r = right + 1;
        while (l < r) {
            while (pos.get(++l) < pivot);
            while (pos.get(--r) > pivot);
            if (l < r) swap(pos, l, r);
        }
        int cnt = r - left + 1;
        if (cnt >= k) return quickSelect(pos, left, r, k);
        return quickSelect(pos, r + 1, right, k - cnt);
    }

    private void swap(List<Integer> pos, int i, int j) {
        int t = pos.get(i);
        pos.set(i, pos.get(j));
        pos.set(j, t);
    }
}
