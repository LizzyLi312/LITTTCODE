//clarify: is there duplicate in t?
// s = "ADOBECODEBANC", t = "ABC"
//1 Hashmap
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        int left = 0;
        int l = -1;
        int min = s.length() + 1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){  //only do something when the character we visit in s is one of the characters in t
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count++;
                while(left < s.length() && count == t.length()){
                    if(right - left + 1 < min){ //range: [right, left]
                        l = left;
                        min = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))){ //shrink the range 
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if(map.get(s.charAt(left)) > 0) count--; 
                    }
                    left++;
                }
            }
        }
        return l == -1 ? "" : s.substring(l, l + min); 
    }
}
//less code 
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";

        int n = s.length(), m = t.length();
        if (n < m) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("#");

        String res = sb.toString();

        int cnt = 0, l = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) cnt++;

                while (cnt == m && l < n) {
                    if (res.length() > r - l + 1) {
                        res = s.substring(l, r + 1);
                    }
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if (map.get(s.charAt(l)) > 0) cnt--;
                    }
                    l++;
                }
            }
        }
        return res.length() == n + 1 ? "" : res;
    }
}
//time: O(n)
