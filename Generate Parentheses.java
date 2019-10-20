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
