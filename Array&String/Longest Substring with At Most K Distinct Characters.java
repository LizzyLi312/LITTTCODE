//sliding window  + array to store the frequency
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if(k == 0) return 0;
        int[] count = new int[256];
        int num = 0, slow = 0, res = 0;
        for(int fast = 0; fast < s.length(); fast++){
            if(count[s.charAt(fast)]++ == 0) num++;
            while(num > k && slow < s.length()){
                count[s.charAt(slow)]--;
                if(count[s.charAt(slow)] == 0) num--;
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
//using HashMap to store the frequency
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if(k == 0) return 0;
        int slow = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                char leftChar = s.charAt(slow);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) - 1);
                    if(map.get(leftChar) == 0) map.remove(leftChar);
                }
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
