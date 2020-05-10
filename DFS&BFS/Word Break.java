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
//time: worst case without pruning: O(n^2) 
//      with pruning O(n)

//dp
//dp[i] mean (0, i - 1) can break into words. so we need to make the array s.length() + 1
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //empty string 
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if(dp[j] && set.contains(s.substring(j, i))){ 
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

//bfs. but cannot deal with a,aa,aaa worst case
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        int[] visited = new int[s.length()];
        while(!que.isEmpty()){
            int start = que.poll();
            for(int end = start + 1; end <= s.length(); end++){
                if(set.contains(s.substring(start, end))){
                    que.add(end);
                    if(end == s.length()) return true;
                }
            }
            visited[start] = 1;
        }
        return false;
    }
}
