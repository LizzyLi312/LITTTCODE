/*dp[i][j]: longest palin in [i, j]
initilize condition: dp[i][j] = 1 (i == j)
dp[i][j] == dp[i + 1][j - 1] + 2 //s.cahrAt(i) == s.charAt(j) 
e.g. a*****a no matter what *** is we add 2 with the longest palin between them
when i and j are not same
a****b then we pick the maximum ****b and a****
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length() - 1; i >=0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j - 1] + 2; //if 
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int len = s.length();
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i - 1][j + 1] + 2;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
        }
        return dp[len - 1][0];
    }
}

//recursion
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        return find(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    private int find(String s, int left, int right, Integer[][] memo){
        if(memo[left][right] != null) return memo[left][right];
        if(left == right) return 1;
        if(left > right) return 0; 
        if(s.charAt(left) == s.charAt(right)) memo[left][right] = 2 + find(s, left + 1, right - 1, memo);
        else memo[left][right] = Math.max(find(s, left + 1, right, memo), find(s, left, right - 1, memo));
        return memo[left][right];
    }
}
