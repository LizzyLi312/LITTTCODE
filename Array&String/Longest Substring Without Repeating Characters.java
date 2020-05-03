class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        while(slow < s.length() && fast < s.length()){
            char c = s.charAt(fast);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max, fast - slow + 1);
                fast++;
            }
            else set.remove(s.charAt(slow++)); //move the character at slow not the c
        }
        return max;
    }
}
