//cannot use HashMap since there will be duplicate word in the array
//use 2 pointers
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) return 0;
        int w1 = -1, w2 = -1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) w1 = i;
            if(words[i].equals(word2)) w2 = i;
        }
        if(w1 == -1 && w2 == -1) return Math.abs(w1 - w2);
    }
}
