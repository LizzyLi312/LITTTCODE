//using array to represent the pattern
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] temp = new int[26];
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                temp[c - 'a']++;
            }
            String key = String.valueOf(temp);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
}
//time: O(the length of all words)
//core: pattern 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp); //using sort to create pattern
            String key = String.valueOf(temp);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str); //remember to put it after create a new pattern!!!
        }
        for(String k : map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }
}
