class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(s, res, 0, new ArrayList<>());
        return res;
    }
    private void dfs(String s, List<List<String>> res, int idx, List<String> sol){
        if(idx == s.length()){
            res.add(new ArrayList<>(sol));
            return;
        }
        for(int i = idx; i <= s.length(); i++){ //need to be = s.length() otherwise it would not hit the base case 
            String str = s.substring(idx, i);
            if(i == idx) continue;
            if(isPanli(str)){
                sol.add(s.substring(idx, i));
                dfs(s, res, i, sol);
                sol.remove(sol.size() -1);
            }
            else continue;
        }
    }
    private boolean isPanli(String s){
        int start = 0, end = s.length() - 1;
        while (start <= end) { //the condition 
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

//using pruning 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        int len = s.length();
        boolean[] m = new boolean[len+1];
        for(int i = 0; i <= len; i++){
            m[i] = true;
        }
        boolean[][] isPal = new boolean[len][len];  //cache if the sub-string is panlidrome or not 
        for(int i = 0; i < len; i++){
            isPal[i][i] = true; //a single letter is panlidrome
            for(int j = i -1; j >= 0; j--){
                isPal[j][i] = s.charAt(j) == s.charAt(i) && (j + 1 == i || isPal[j + 1][i - 1]); //j + 1 = i means they are the same position. 
                                                                                                //isPal means the inner chunk if panli so the start and the end are the same then the new chunk if panli again 
            }
        }
        dfs(res, new ArrayList<>(), s, 0, m, isPal);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> sol, String s, int idx, boolean[] m, boolean[][] isPal){
        int len = s.length();
        if(idx == len){
            res.add(new ArrayList<>(sol));
            return;
        }
        int curSize = res.size();
        for(int length = 0; idx + length < len; length++){
            if(isPal[idx][idx + length] && m[idx + length + 1]){
                String str = s.substring(idx, idx + length + 1);
                sol.add(str);
                dfs(res, sol, s, idx + length +1, m, isPal);
                sol.remove(sol.size() - 1);
            }
        }
        if(curSize == res.size()) m[idx] = false;
    }
}
