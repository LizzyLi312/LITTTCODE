class Solution {
    private int res = 0;
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for(int len = 1; len <= n; len++){
            int count = 0;
            for(int i = 1; i <= len; i++){
                count += memo[i - 1] * memo[len - i];  //left node * right node
            }
            memo[len] = count;
        }
        return memo[n];
    }
}
