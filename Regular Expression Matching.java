//if there are only '.' 2 pointers can solve the prob. But if there are '*' we need dfs to see how many character '*' can offset
class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        return dfs(s, p, 0, 0);
    }
    private boolean dfs(String s, String p, int idxS, int idxP){
        int lenP = p.length(), lenS = s.length();  
        if(idxP == lenP) return idxS == lenS;  //do not use idxS == lenS as the condition since there could be * in the end. e.g: "aaa" "a*"
//         char c = s.charAt(idxS);  cannot cached since it could be idxS - 1 it will be outofbounday
//         char b = p.charAt(idxP);
        //check non '*'
        if(idxP == lenP - 1 || p.charAt(idxP + 1) != '*'){ //last position of P since there is no letter after that || the next character is '.' or letter since the * symbol always bundle with the previous one
            if(idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) return dfs(s, p, idxS + 1, idxP + 1);  //before check match we need to check the boundary
            else return false;
        }
        //check '*'
        else{  //if there is '*' in p
            int i = idxS - 1;  //can be knew after the variable's value in dfs determined. since we need to start from idxS. So the while loop need to add an condition i < idxS
            while(i < lenS && (i < idxS || p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i))){ //need while loop since we do not know how many letters in s could be matched 
                //next step: match(i+1, idxP+2) since idxP is a non '*'letter and idxP+1 is a '*' letter.so next one should be the one after these two.
                //why i + 1? since we need to start matching from the min length of string it can match which is 0
                if(dfs(s, p, i + 1, idxP + 2)) return true;  
                i++;
            }
            return false;
        }
    }
}
