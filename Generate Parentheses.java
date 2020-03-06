//in the searching process the left parenthese can be more than the right ones since you can add the right ones
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, res);
        return res;
    }
    private void dfs(int n, int l, int r, StringBuilder sb, List<String> res){
        if(l == n && r == n){
            res.add(sb.toString());
            return;
        }
        if(l < n){
            sb.append('(');
            dfs(n, l + 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);  //only delete (
        }
        if(r < l){
            sb.append(')');
            dfs(n, l, r + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);  //only delete )
        }
    }
}
//using dfs. 2n layers: 2n positions and 2 branches: adding ( or adding )
//time: summation from 2 power of 0 to 2 power of 2n - 1

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, new StringBuilder(), 0);  //diff = leftP - rightP
        return res;
    }
    private void dfs(int n, List<String> res, StringBuilder sol, int diff){
        if(sol.length() == 2 * n && diff == 0){
            res.add(sol.toString());
            return;
        }
        if(diff < 0 || sol.length() > 2 * n) return;
        sol.append('(');
        dfs(n, res, sol, diff + 1);
        sol.setLength(sol.length() - 1);
        sol.append(')');
        dfs(n, res, sol, diff - 1);
        sol.setLength(sol.length() - 1);
    }
}
