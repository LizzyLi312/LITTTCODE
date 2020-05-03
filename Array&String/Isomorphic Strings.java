class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) continue;
                else return false;
            }
            else if(!map.containsValue(b)) map.put(a, b); //core: double direction check 
            else return false;
        }
        return true;
    }
}
//2 hashmaps
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char a = s.charAt(i);
            char b = t.charAt(i); //(a, b)
            if(map1.containsKey(a)){ 
                if(map1.get(a).equals(b)) continue; //(a, b)
                else return false; //(a, c) in the map
            }
            else if(!map2.containsKey(b)){ // there is no c in the map and c isnt connected to other characters
                map1.put(a, b); 
                map2.put(b, a);
            }
            else return false;
        }
        return true;
    }
}
