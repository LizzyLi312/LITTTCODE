//solution1: brutal force TLE
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        return longestCommonSubsequence(text1, 0, text2, 0);
    }

    private int longestCommonSubsequence(String s1, int idx1, String s2, int idx2) {
        if (idx1 == s1.length() || idx2 == s2.length()) return 0;

        if (s1.charAt(idx1) == s2.charAt(idx2)) return 1 + longestCommonSubsequence(s1, idx1 + 1, s2, idx2 + 1);
        else return Math.max(longestCommonSubsequence(s1, idx1 + 1, s2, idx2), longestCommonSubsequence(s1, idx1, s2, idx2 + 1));
    }
}

// solution2 : dp
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
