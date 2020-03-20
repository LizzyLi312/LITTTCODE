//similar to calculator. but does not need stack. When there are parenthese then we need stack
//need to memorize a last value to deal with the * symbol
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        // if(num == null) return res;
        // dfs(num, target, new StringBuilder(), 0, 0, res, 0);
        dfs(res, num,0 ,0, new StringBuilder(), target);
        return res;
        
    }
    private void dfs(List<String> res, String num, long last, long curVal, StringBuilder sb, int target){
        int len = num.length();
        if(len == 0 && curVal == target){
            res.add(sb.toString());
            return;
        }
        if(len == 0) return;
        int lenSb = sb.length();
        int val = 0;
        for(int i = 0; i < len; i++){
            val = val * 10 + num.charAt(i) - '0';
            if(sb.length() != 0){
                dfs(res, num.substring(i + 1), val, curVal + val, sb.append("+" + val), target);
                sb.setLength(lenSb);
                dfs(res, num.substring(i + 1), -val, curVal - val, sb.append("-" + val), target);
                sb.setLength(lenSb);
                dfs(res, num.substring(i + 1), last * val, (curVal - last) + last * val, sb.append("*" + val), target);
                sb.setLength(lenSb);
            }
            else{
                dfs(res, num.substring(i + 1), val, curVal + val, sb.append(val), target);
                sb.setLength(lenSb);
            }
            if(val == 0) break;
        }
    }
//     private void dfs(String num, int target, StringBuilder sol, long sum, long lastVal, List<String> res, int idx){
//         int len = num.length();
//         if(idx == len && sum == target){
//             res.add(sol.toString());
//             return;
//         }
//         if(idx > len) return;
//         long val = 0;
//         int lenSol = sol.length();
//         for(int i = idx; i < len; i++){
//             val = 0 * val + (num.charAt(i) - '0');
//             if(sol.length() == 0){
//                 sol.append(val);
//                 dfs(num, target, sol, sum + val, val, res, i + 1);
//                 sol.setLength(sol.length() - 1);
//             }
//             else{
//                 sol.append("+" + val);
//                 dfs(num, target, sol, sum + val, val, res, i + 1);
//                 sol.setLength(lenSol);
                
//                 sol.append("-" + val);
//                 dfs(num, target, sol, sum - val, -val, res, i + 1);
//                 sol.setLength(lenSol);
                
//                 sol.append("*" + val);
//                 dfs(num, target, sol, (sum - lastVal) + lastVal * val, lastVal * val, res, i + 1);
//                 sol.setLength(lenSol);
//             }
//             if(val != 0) break;
//         }
//     }
}
