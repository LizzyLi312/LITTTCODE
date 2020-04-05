class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length, sum = 0;
        int dp[][] = new int[len][len];
        for(int i = len  - 1; i >= 0; i--){
            sum += nums[i];
            for(int j = i; j < len; j++){
                if(i == j){
                    dp[i][j] = nums[i];
                    continue;
                }
                int a = 0, b = 0, c = 0;
                if(i + 2 <= j){
                    a = dp[i + 2][j];
                    b = dp[i + 1][j - 1];
                    c = dp[i][j - 2];
                }
                else{
                    a = 0;
                    b = 0;
                    c = 0;
                }
                dp[i][j] = Math.max(nums[i] + Math.min(a, b), nums[j] + Math.min(b, c));
            }
        }
        return dp[0][len - 1] >= sum - dp[0][len - 1];
    }
}
