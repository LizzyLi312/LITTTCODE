//pruning, dfs
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1]; //??
        return dfs(s, 0, p, 0, memo);
    }
    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] memo){
        if(memo[idxS][idxP] != null) return memo[idxS][idxP];
        if(idxP == p.length()) return idxS == s.length() ? true : false;
        if(p.charAt(idxP) != '*'){ 
            if(idxS < s.length() && (s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '?')){
                memo[idxS][idxP] = dfs(s, idxS + 1, p, idxP + 1, memo);
                return memo[idxS][idxP];
            }
            else{
                memo[idxS][idxP] = false;  //when it is not * but other case. e.g. idxS >= s.length() or s.charAt(idxS) != p.charAt(idxP)
                return false;
            }
        }
        
        else{
            for(int i = 0; i <= s.length(); i++){ ////need to make sure s is in the range
                if(i + idxS <= s.length() && dfs(s, idxS + i, p, idxP + 1, memo)){
                    memo[idxS][idxP] = true;
                    return true;
                }
            }
            memo[idxS][idxP] = false;
        }
        return memo[idxS][idxP];
    }
}
