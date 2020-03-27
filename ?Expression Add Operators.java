//similar to calculator. but does not need stack. When there are parenthese then we need stack
//need to memorize a last value to deal with the * symbol
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null) return res;
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
        int lenSb = sb.length(); //need to be cached befroe the dfs starts. can be put in the for loop too 
        long val = 0; //need to be long 
        for(int i = 0; i < len; i++){
            val = val * 10 + num.charAt(i) - '0'; //there could be no operator sign between 2 numbers
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
            if(val == 0) break; //last place otherwise cases like this cannot pass: "105" 5 Expected: ["1*0+5","10-5"]. the first one could be missed
        }
    }
}
