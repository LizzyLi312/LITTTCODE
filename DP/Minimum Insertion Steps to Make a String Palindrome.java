class Solution {
    public int minInsertions(String s) {
        if(s == null || s.length() < 2) return 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                //compare input string with the reversed input string. and check the longest sub sequence they have. if they                   //have 3 characters in commment and the length is 5 then only need to add 2 more characters to make it palin
                //since the palin is the same string when you reverse it 
                if(s.charAt(i) == s.charAt(s.length() - 1 - j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return s.length() - dp[s.length()][s.length()];
    }
}
