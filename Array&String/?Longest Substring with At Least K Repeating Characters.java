class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() < k) return 0;
        char[] ch = s.toCharArray();
        return helper(ch, 0, s.length(), k);
    }
    private int helper(char[] str, int start, int end, int k){
        if(end - start < k) return 0;
        int[] count = new int[26];
        for(int i = start; i < end; i++){
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] < k && count[i] > 0){ //if count[i] == 0 then it doesnt exsit. we do not need to deal with it
                for(int j = start; j < end; j++){
                    if(str[j] - 'a' == i){
                        int left = helper(str, start, j, k); //the max length without this < k frequence character 
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right); //if there is one character repeat less then k times return left, right max
                    }
                }
            }
        }
        return end - start; //if every character repeats over kt= times then return end and start
    }
}
//time: O(n^2)

 public int longestSubstring(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }
    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[26];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end) - 'a']++ == 0) numUnique++; // increment map[c] after this statement
            if (map[s.charAt((end)++) - 'a'] == k) numNoLessThanK++; // inc end after this statement

            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin) - 'a']-- == k) numNoLessThanK--; // decrement map[c] after this statement
                if (map[s.charAt(begin++) - 'a'] == 0) numUnique--; // inc begin after this statement
            }

            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
                d = Math.max(end - begin, d);
        }

        return d;
    }
