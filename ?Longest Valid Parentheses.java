class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+ 1];
        int max = 0;
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) ==')') dp[i] = 0;
            else if(s.charAt(i) == '('){
                int j = i + dp[i + 1] + 1;
                if(j < len && s.charAt(j) ==')'){
                    dp[i] = dp[i + 1] + 2;
                    if(j + 1 < len) dp[i] += dp[j + 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
