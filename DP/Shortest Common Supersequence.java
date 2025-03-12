class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0) return str2;
        if (str2 == null || str2.length() == 0) return str1;

        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // finding the longest subsequence between s1 and s2 using dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int idx1 = m - 1, idx2 = n - 1;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 && idx2 >= 0) { // we need to get the longest subseq so we visit it from the back 
            if (str1.charAt(idx1) == str2.charAt(idx2)) {
                sb.append(str1.charAt(idx1));
                idx1--;
                idx2--;
            // if they are not the same we going for the route with longer subsq
            } else if (dp[idx1 - 1 + 1][idx2 + 1] > dp[idx1 + 1][idx2 - 1 + 1]) { // str1 has longer subsq
                sb.append(str1.charAt(idx1));
                idx1--;
            } else {
                sb.append(str2.charAt(idx2));
                idx2--;
            }
        }
        // take care of the unfinished strings
        while (idx1 >= 0) {
            sb.append(str1.charAt(idx1--));
        }

        while (idx2 >= 0) {
            sb.append(str2.charAt(idx2--));
        }

        return sb.reverse().toString(); // need to reverse since we append the string in reverse order

    }
}
