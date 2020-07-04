//sliding window
class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] counter = new int[26];
        int len = s.length(), start = 0, max = 0;
        char maxChar = '\0';
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            counter[c - 'A']++;
            if(max == '\0' || counter[c - 'A'] > counter[maxChar - 'A']) maxChar = c;
            while(i - start + 1 - counter[maxChar - 'A'] > k){ //when there is more than the second different character is more than k
                char startChar = s.charAt(start++); //move left pointer 
                counter[startChar - 'A']--; 
                if(startChar == maxChar){
                    for(char ch = 'A'; ch <= 'Z'; ch++){ //find the next character 
                        if(counter[ch - 'A'] > counter[maxChar - 'A']) maxChar = ch;
                    }
                }
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
