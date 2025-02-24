// find the different between the children on the same level
class Solution {
    public int minIncrements(int n, int[] cost) {
        int[] res = new int[1];
        dfs(res, 0, cost);
        return res[0];
    }

    private int dfs(int[] res, int idx, int[] cost) {
        if (idx > cost.length - 1) return 0;
        int left = dfs(res, idx * 2 + 1, cost);
        int right = dfs(res, idx * 2 + 2, cost);
        int diff = Math.abs(left - right);
        res[0] += diff;
        return cost[idx] + Math.max(left, right);
    }
}
