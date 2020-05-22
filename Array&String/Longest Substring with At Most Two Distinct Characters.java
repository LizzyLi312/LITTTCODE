//2 pointers. record the last position of 2 character 
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        char c1 = '\0', c2 = '\0'; 
        int idx1 = -1, idx2 = -1, start = 0, max = 0; //it is easier to initialize idx1 & 2 with -1 
        for(int i = 0; i < len; i++){ //when enter the for loop. c2 will be updated first
            char c = s.charAt(i);
            if(c == c1) idx1 = i;
            else if(c == c2) idx2 = i;
            else{
                if(idx1 < idx2){
                    start = idx1 + 1;
                    c1 = c;
                    idx1 = i;
                }
                else{
                    start = idx2 + 1;
                    c2 = c;
                    idx2 = i;
                }
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}
