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
