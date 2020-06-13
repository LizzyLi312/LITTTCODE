//2 pointers. find the last index of each section. the last index relate to every charactres in the section.
//so we need to record the last appear index of the character 
class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i; //the last index of each character 
        }
        int last = 0, start = 0; //2 pointers
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']); //make sure the last index include all the character. update last when there is new character
            if(last == i){ //means no new character so far 
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
