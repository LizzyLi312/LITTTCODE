//dp.
//s1 character s1, s2 character s2, s3 character s3 
//four cases: s1 = s3; s2 = s3; s1 = s2 = s3; s1 != s3 && s2 != s3
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] memo = new boolean[len1 + 1][len2 + 1]; //array_idx = dp_idx + 1. since dp[0] is an empty string 
        memo[0][0] = true;
        //initialize
        for(int i = 0; i < len1; i++){ //s2 is empty string so there is only s1 to match s3
            memo[i + 1][0] = memo[i][0] && (s1.charAt(i) == s3.charAt(i));
        }
        for(int j = 0;j < len2; j++){ //s1 is empty string 
            memo[0][j + 1] = memo[0][j] && (s2.charAt(j) == s3.charAt(j));
        }
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                int k = i + j + 1; //k starts from 1 since 0 already matched. and we can get from an exmaple
                //"ab" "bc" "babc": when s3 = c(idx = 3) s1 = b(idx = 1) s2 = b(idx = 1)
                if(s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) memo[i + 1][j + 1] = memo[i][j + 1] || memo[i + 1][j]; //s1 = s2 = s3
                else if(s3.charAt(k) == s1.charAt(i)) memo[i + 1][j + 1] = memo[i][j + 1]; //s1 = s3
                else if(s2.charAt(j) == s3.charAt(k)) memo[i + 1][j + 1] = memo[i + 1][j]; // s2 = s3
                else memo[i + 1][j + 1] = false;
            }
        }
        return memo[len1][len2];
    }
}
