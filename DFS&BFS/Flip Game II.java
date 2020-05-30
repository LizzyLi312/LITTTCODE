//return single value question, so we can pruning 
class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0) return false;
        return dfs(s.toCharArray(), new HashMap<String, Boolean>());
    }
    private boolean dfs(char[] s, HashMap<String, Boolean> map){  //pruning
        int len = s.length;
        String str = String.valueOf(s);
        Boolean ret = map.get(str);
        if(ret != null) return ret;
        for(int i = 0; i < len - 1; i++){
            if(s[i] == '+' && s[i + 1] == '+'){
                s[i] = '-';
                s[i + 1] = '-';
                boolean res = dfs(s, map); //cache the res before backtracing 
                s[i] = '+';
                s[i + 1] = '+';
                if(!res){ //if the res is true, it means the 2nd hand player won
                    map.put(new String(str), true);
                    return true;
                }
            }
        }
        map.put(new String(str), false); //means no -s to flip so return false
        return false;
    }
}
