class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0) return res;
        Map<Character, Integer> common= new HashMap<>();
        for(int i = 0; i < A[0].length(); i++){  //build up the 1st hashmap
            common.put(A[0].charAt(i), common.getOrDefault(A[0].charAt(i), 0) + 1);
        }
        for(int i = 1; i < A.length; i++){ //find common
            Map<Character, Integer> temp = new HashMap<>();
            for(int j = 0; j < A[i].length(); j++){
                char ch = A[i].charAt(j);
                if(common.containsKey(ch)) temp.put(ch, Math.min(temp.getOrDefault(ch, 0) + 1, common.get(ch)));
            }
            common = temp;
        }
        for(char ch : common.keySet()){
            for(int i = 0; i < common.get(ch); i++){
                res.add(String.valueOf(ch));  //Returns the string representation of the specific argument
            }
        }
        return res;
    }
}

//using 2 HashMaps. 1st to store common character from the previous Strings. 2nd one store the common characters from the 1st hashmap and the current string 
