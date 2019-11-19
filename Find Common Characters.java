class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++){
                int count = map.getOrDefault(A[i].charAt(j), 0);
                map.put(A[i].charAt(j), count + 1);
            }
        }
        for(char ch : map.keySet()){
            for(int i = 0; i < map.get(ch) / 3; i++){
                res.add(new String(ch));
            }
        }
        return res;
    }
}
