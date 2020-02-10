class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        boolean[] memo = new boolean[s.length() + 1];  //pruning
        Arrays.fill(memo, true);
        dfs(s, wordDict, res, 0, new StringBuilder(), memo);
        return res;
    }
    //if one thing is used every time then put it in the signuatrue 
    private void dfs(String s, List<String> wordDict, List<String> res, int idx, StringBuilder sol, boolean[] memo){
        if(idx == s.length()){
            res.add(sol.toString());
            return;
        }
        int curSize = res.size();
        for(int i = idx + 1; i <= s.length(); i++){
            String str = s.substring(idx, i);
            if(wordDict.contains(str) && memo[i]){
                int prevLen = sol.length();
                if(prevLen == 0) sol.append(str);
                else sol.append(" " + str);
                dfs(s, wordDict, res, i, sol, memo);
                sol.setLength(prevLen);
            }
        }
        if(curSize == res.size()) memo[idx] = false;
    }
}
