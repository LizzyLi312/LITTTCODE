class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        HashSet<String> set = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){ //sort String from shortest to longest 
                return s1.length() - s2.length();
            }
        });
        for(int i = 0; i < words.length; i++){
            if(canForm(words[i], set)) res.add(words[i]);
            set.add(words[i]);
        }
        return res;
    }
    private boolean canForm(String word, HashSet<String> dict){
        if(dict.isEmpty()) return false;
        //word break, dp
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++){
            for(int j = 0; j < i; j++){
                if(!dp[j]) continue;
                if(dict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
