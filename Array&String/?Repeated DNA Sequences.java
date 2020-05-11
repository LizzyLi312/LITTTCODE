//Rabin-Karp Algorithm for Pattern Searching
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) return new ArrayList<>();
        Map<Character, Integer> chara = new HashMap<>();
        chara.put('A', 0);
        chara.put('C', 1);
        chara.put('G', 2);
        chara.put('T', 3);
        int aL = (int) Math.pow(4, 9); //weight
        Set<String> res = new HashSet<>(); //result 
        Set<Integer> hash = new HashSet<>(); //pattern 
        int rhash = 0;
        for(int i = 0; i < s.length(); i++){
            if(i > 9) rhash -= aL * chara.get(s.charAt(i - 10)); //siliding window size: 10
            rhash = chara.size() * rhash + chara.get(s.charAt(i));
            if(i >= 9 && !hash.add(rhash)) res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<>(res);
    }
}
//time: O(n - L)
