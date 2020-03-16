class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        int rmL = 0, rmR = 0; //calculate how many ( or ) should be deleted 
        for(char c : s.toCharArray()){
            if(c == '(') rmL++;
            else if(c == ')'){
                if(rmL > 0) rmL--;  //) can offset the ( shold be deleted
                else rmR++;
            }
        }
        dfs(s, set, 0, rmL, rmR, new StringBuilder(), 0);
        return new ArrayList<String>(set);
    }
    private void dfs(String s, HashSet<String> set, int idx, int rmL, int rmR, StringBuilder sol, int diff){
        //diff: sol's ( - sol's )
        if(idx == s.length() && diff == 0 && rmR == 0 && rmL == 0){
            set.add(sol.toString());
            return;
        }
        if(diff < 0 || idx >= s.length() || rmR < 0 || rmL < 0) return;  //if idx == s.length() it doesnt work too 
        char c = s.charAt(idx);
        if(c == '('){ //2 cases for the parenthese: save or delete
            //delete: not add in the res
            dfs(s, set, idx + 1, rmL - 1, rmR, sol, diff);
            //save: add in the res
            sol.append('(');
            dfs(s, set, idx + 1, rmL, rmR, sol, diff + 1);
            sol.setLength(sol.length() - 1);
        }
        else if(c == ')'){
            dfs(s, set, idx + 1, rmL, rmR - 1, sol, diff);
            sol.append(')');
            dfs(s, set, idx + 1, rmL, rmR, sol, diff - 1);
            sol.setLength(sol.length() - 1);
        }
        else{ //for the other character put in the sol 
            sol.append(c);
            dfs(s, set, idx + 1, rmL, rmR, sol, diff);
            sol.setLength(sol.length() - 1);
        }
    }
}

//time: O(2^n) binary tree: delete / not delete; n layers since n nodes
