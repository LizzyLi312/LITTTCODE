class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int[][] memo = new int[lenT + 1][lenS + 1]; //since result happends at i + 1, j + 1 
        for(int j = 0; j <= lenS; j++){
            memo[0][j] = 1; //means t is empty string, t is a string. empty string is any string's subsequence. so there is a way to build t from s
        }
        //for(int i = 1; i <= lenT; i++){
        //  memo[i][0] = 0;  //s is non empty but t is empty. so there is no way that s can build t  
        //}
        for(int i = 0; i < lenT; i++){
            for(int j = i; j < lenS; j++){
                char tc = t.charAt(i), sc = s.charAt(j);
                if(tc != sc) memo[i +1][j+1] = memo[i +1][j]; //since we are visiting s to match t 
                else memo[i + 1][j + 1] = memo[i + 1][j] + memo[i][j]; //if they are the same. we have 2 options and we need to add them together: do not match: then memo[i + 1][j]; match : memo[i][j]. 
            }
        }
        return memo[lenT][lenS];
    }
}
