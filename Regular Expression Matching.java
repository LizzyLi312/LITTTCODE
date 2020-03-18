class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        return dfs(s, p, 0, 0);
    }
    private boolean dfs(String s, String p, int idxS, int idxP){
        int lenP = p.length(), lenS = s.length();  
        if(idxP == lenP) return idxS == lenS;  //do not use idxS == lenS as the condition since there could be * in the end. e.g: "aaa" "a*"
        char c = s.charAt(idxS);
        char b = p.charAt(idxP);
        if(idxP == lenP - 1 || p.charAt(idxP + 1) != '*'){ //last position of P || the next character is '.' or letter
            if(idxS < lenS && (b == '.' || b == c)) return dfs(s, p, idxS + 1, idxP + 1);
            else return false;
        }
        else{  //if there is '*' in p
            int i = idxS - 1;
            while(i < lenS && (i < idxS || b == '.' || b == s.charAt(i))){ //need while loop since we do not know how many letters in s could be matched 
                if(dfs(s, p, i + 1, idxP + 2)) return true;
                i++;
            }
            return false;
        }
    }
}
