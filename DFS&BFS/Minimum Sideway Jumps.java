//TLE: O(3^n)
class Solution {
    int res;
    public int minSideJumps(int[] obstacles) {
        if (obstacles == null || obstacles.length == 0) return 0;

        res = Integer.MAX_VALUE;
        dfs(obstacles, 0, 0, 2);
        return res;
    }

    private void dfs(int[] o, int idx, int step, int pos) {
        if (idx == o.length - 1) {
            res = Math.min(step, res);
            return;
        }
        
        if (o[idx] == pos) return;
        
        for (int i = 1; i <= 3; i++) {
            if (pos == i) dfs(o, idx + 1, step, pos);
            else if (o[idx] != i){
                dfs(o, idx + 1, step + 1, i);
            }
        }
    }
}

// dfs + memo 
// time: O(n)
class Solution {
    int res;
    boolean[][] visited;
    public int minSideJumps(int[] obstacles) {
        if (obstacles == null || obstacles.length == 0) return 0;

        int[][] memo = new int[4][obstacles.length];
        for (int i = 0; i < 4; i++) Arrays.fill(memo[i], -1);

        return dfs(obstacles, 0, 2, memo);
    }

    private int dfs(int[] o, int idx, int pos, int[][] memo) {
        if (idx == o.length - 1) return 0;
        
        if (o[idx] == pos) {
            return Integer.MAX_VALUE;
        }

        if (memo[pos][idx] != -1) return memo[pos][idx]; 
        if (o[idx + 1] != pos) return dfs(o, idx + 1, pos, memo); // this is the best way without any jumps
        int ans = Integer.MAX_VALUE; // need this to record the min value of different routes
        for (int i = 1; i <= 3; i++) {
            if (o[idx] != i && pos != i){
                ans = Math.min(1 + dfs(o, idx + 1, i, memo), ans);
            }
        }
        memo[pos][idx] = ans;
        return ans;
    }
}
