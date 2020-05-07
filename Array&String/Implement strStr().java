class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length(); i++){
            for(int j = 0; j <= needle.length(); j++){
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1; //out of range 
                if(needle.charAt(j) != haystack.charAt(i + j)) break; //find the starting position 
            }
        }
        return -1;
    }
}
