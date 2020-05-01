//O(n^2) using extra space
class Solution {
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0) return S;
        char[] s = S.toCharArray();
        int i = 1;
        while(i < s.length){
            if(s[i] == s[i - 1]){
                s = build(s, i);
                if(i > 1) i--;
            }
            else i++;
        }
        return String.valueOf(s);
    }
    private char[] build(char[] s, int idx){
        char[] temp = new char[s.length - 2];
        int j = 0;
        for(int i = 0; i < temp.length; i++){
            if(j == idx - 1 || j == idx) {
                j++;
                i--;
                continue;
            }
            temp[i] = s[j];
            j++;
        }
        return temp;
    }
}

//2 pointers in-place
//only move the slow pointer there are 2 same character. delete them by moving slow pointer 2 position forward
//[0, i] is the answer 
//(i, j) the abandoned part 
//[j, length) is thre part we need to check 
//time: O(n)
class Solution {
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0) return S;
        int i = 0; //slow pointer
        char[] res = S.toCharArray();
        for(int j = 0; j < res.length; j++){ //fast pointer 
            res[i] = res[j];
            if(i > 0 && res[i - 1] == res[i]){
                i = i - 2;
            }
            i++;
        }
        return new String(res, 0, i);
    }
}
//public String(char[] value, int offset, int count)
/*
value - Array that is the source of characters
offset - The initial offset
count - The length
*/

//Solution3: using stack. compare cur character with peek 
