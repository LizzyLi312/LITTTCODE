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
