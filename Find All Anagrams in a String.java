//clarify: any duplicate 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {  //size: m, n
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null) return res;
        for(int i = 0; i <= s.length() - p.length(); i++){ //time: m - n
            if(checkPattern(s.substring(i, i + p.length()), p)) res.add(i);  //substring time complexity: O(n) since the substring length is p.length()
        }
        return res;
    }
    private boolean checkPattern(String sub, String p){
        if(sub.length() != p.length()) return false;
        int[] pattern = new int[26];  //count the num of the characters
        for(char s :sub.toCharArray()){
            pattern[s - 'a']++;
        }
        for(char s : p.toCharArray()){
            pattern[s - 'a']--;
        }
        for(int i : pattern){
            if(i != 0) return false;
        }
        return true;
    }
}

//time: O((m - n) (n + n + n + 26))
