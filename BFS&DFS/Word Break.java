class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null ||wordDict.size() == 0) return false;
        Boolean[] memo = new Boolean[s.length()];  //pruning to save time
        return dfs(s, wordDict, 0, memo);
    }
    private boolean dfs(String s, List<String> wordDict, int idx, Boolean[] memo){
        if(s.length() == idx) return true; //do not need to prune here
        if(memo[idx] != null) return memo[idx];
        for(int i = idx; i < s.length(); i++){ //dfs: check whether it can be parsed from idx to len - 1 or not
            String str = s.substring(idx, i + 1);  //range: [idx, i + 1)
            if(wordDict.contains(str)){
                if(dfs(s, wordDict, i + 1, memo)){ //if idx to i is in the Dict, then start check from i + 1
                    memo[idx] = true;
                    return memo[idx];
                } 
            }
        }
        memo[idx] = false;  //if it didnt return true then return false
        return memo[idx];
    }
}
