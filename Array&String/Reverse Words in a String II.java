class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        s = reverse(s);
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' ') continue;
            if(s[i] != ' '){
                int j = i + 1;
                while(j < s.length && s[j] != ' ') j++;
                int left = i, right = j - 1;
                while(left < right) swap(s, left++, right--);
                i = j;
            }
        }
    }
    private char[] reverse(char[] s){
        int left = 0, right = s.length - 1;
        while(left < right) swap(s, left++, right--);
        return s;
    }
    private void swap(char[] s, int left, int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
