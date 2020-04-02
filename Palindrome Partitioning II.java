//using dp & memo to record whether it is the palindrome
//dp: the min cut so far
class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] memo = new boolean[len][len]; //substring(a, b) if a palindrome or not
        int[] dp = new int[len + 1];
        for(int i = len - 1; i >= 0; i--){
            dp[i] = len - i; //assume each letter we've checked is only a palinfrome by itself
            for(int j = i; j < len; j++){
                if(i == j || (s.charAt(i) == s.charAt(j) && (j == i + 1 || memo[i + 1][j - 1]))){
                //The default value of the elements in a Java boolean array is false
                //since if the subarray is not a single letter or theyre not the same letter then it not palindrome
                //if the end letter and beginning letter are same then check the rest string is panlinrome or not
                //j == i + 1: when i and j are next to each other memo will be false since it hasnt been checked yet
                    memo[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1); //if i to j is a palindrome then just need to cut dp[i + 1] + 1 times
                }
            }
        }
        return dp[0] - 1; //the last cut is at idx 0 which is not needed so we should - 1
    }
}
